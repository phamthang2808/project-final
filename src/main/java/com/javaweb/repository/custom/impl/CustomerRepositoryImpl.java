package com.javaweb.repository.custom.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import com.javaweb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public void buildJoinQuery(CustomerSearchBuilder customerSearchBuilder, StringBuilder join) {
        Long staffId = customerSearchBuilder.getStaffId();
        if (staffId != null) {
            join.append(" join assignmentcustomer ac on c.id = ac.customerid ");
        }
    }

    public void nomalQuerry(CustomerSearchBuilder customerSearchBuilder, StringBuilder where) {
        try {
            Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
            for (Field it : fields) {
                it.setAccessible(true);
                String fieldNName = it.getName();
                if (!fieldNName.equals("staffId")) {
                    Object value = it.get(customerSearchBuilder);
                    if (StringUtils.check(value)) {
                        if (it.getType().getName().equals("java.lang.long") || it.getType().getName().equals("java.lang.Integer")) {
                            where.append(" and c." + fieldNName + " = " + value);
                        } else {
                            where.append(" and c." + fieldNName + " LIKE '%" + value + "%'");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void spiecialQuerry(CustomerSearchBuilder customerSearchBuilder, StringBuilder where) {
        Long staffId = customerSearchBuilder.getStaffId();
        if (staffId != null) {
            where.append(" and ac.staffid = " + staffId);
        }
    }

    @Override
    public List<CustomerEntity> findAll(CustomerSearchBuilder customerSearchBuilder, Pageable pageable) {
        StringBuilder sql = new StringBuilder(buildQueryFilter());
        StringBuilder join = new StringBuilder();
        StringBuilder where = new StringBuilder("where is_active != 0");
        buildJoinQuery(customerSearchBuilder, join);
        spiecialQuerry(customerSearchBuilder, where);
        nomalQuerry(customerSearchBuilder, where);
        sql.append(join).append(where).append(" group by c.id")
                .append(" limit ").append(pageable.getPageSize()).append("\n")
                .append(" offset ").append(pageable.getOffset());
        System.out.println("sql final: " + sql.toString());
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    private String buildQueryFilter() {
        String sql = "select c.*, count(c.id) from customer c ";
        return sql;
    }

    @Override
    public int countTotalItem() {
        StringBuilder sql = new StringBuilder("SELECT c.*, count(c.id) FROM customer c ");
        StringBuilder where = new StringBuilder(" where 1=1 and is_active != 0");
        sql.append(where).append(" GROUP BY c.id;");
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList().size();
    }

//    @Override
//    public void deleteCustomer(Long[] ids) {
//        StringBuilder delete = new StringBuilder("UPDATE customer SET is_active = 0 WHERE id IN (");
//        if (ids != null && ids.length > 0) {
//            String code = Arrays.stream(ids).map(String::valueOf).collect(Collectors.joining(", "));
//            delete.append(code);
//            delete.append(");");
//        } else {
//            throw new RuntimeException("data not null!");
//        }
//        System.out.println(delete);
//        Query query = entityManager.createNativeQuery(delete.toString(), CustomerEntity.class);
//        query.executeUpdate();
//    }

}
