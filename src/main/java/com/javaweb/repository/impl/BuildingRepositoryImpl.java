//package com.javaweb.repository.impl;
//
//import java.lang.reflect.Field;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import com.javaweb.repository.entity.BuildingEntity;
//import org.springframework.stereotype.Repository;
//import com.javaweb.builder.BuildingSearchBuilder;
//
//@Repository
//public class BuildingRepositoryImpl  {
//    @PersistenceContext
//    private EntityManager entityManager;
//    public void buildJoinQuery(BuildingSearchBuilder buildingSearchBuilder, StringBuilder joinQuery) {
//        Long staffId = buildingSearchBuilder.getStaffId();
//        if (staffId != null) {
//            joinQuery.append(" join assignmentbuilding ab ON b.id = ab.buildingid ");
//        }
//        Long areaFrom = buildingSearchBuilder.getAreaFrom();
//        Long areaTo = buildingSearchBuilder.getAreaFrom();
//        if (areaFrom != null || areaTo != null) {
//            joinQuery.append("join Rentarea ra ON ra.buildingid  = b.id");
//        }
////        List<String> typecode = buildingSearchBuilder.getTypecode();
////        if (typecode != null && typecode.size() != 0) {
////            joinQuery.append(" join buildingrenttype brt ON b.id = brt.buildingid")
////                    .append(" join renttype rt ON brt.renttypeid = rt.id");
////        }
//
//
//    }
//
//    public void nomalQuerry(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
//        try {
//            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
//            for (Field it : fields) {
//                it.setAccessible(true);
//                String fieldName = it.getName();
//                if (!fieldName.equals("staffId") && !fieldName.equals("typecode") && !fieldName.startsWith("price")
//                        && !fieldName.startsWith("area")) {
//                    Object value = it.get(buildingSearchBuilder);
//                    if (value != null) {
//                        if (it.getType().getName().equals("java.lang.Long")
//                                || it.getType().getName().equals("java.lang.Integer")) {
//                            where.append(" and b." + fieldName + " = " + value);
//                        } else {
//
//                            where.append(" and b." + fieldName + " LIKE '%" + value + "%'");
//                        }
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void specialQuerry(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
//        Long staffId = buildingSearchBuilder.getStaffId();
//        if (staffId != null) {
//            where.append(" and ab.staffid = " + staffId);
//        }
//        Long areaFrom = buildingSearchBuilder.getAreaFrom();
//        Long areaTo = buildingSearchBuilder.getAreaTo();
//        if (areaFrom != null) {
//            where.append(" and ra.value >= " + areaFrom);
//        }
//        if (areaTo != null) {
//            where.append(" and ra.value <= " + areaTo);
//        }
//        Long priceFrom = buildingSearchBuilder.getPriceFrom();
//        Long priceTo = buildingSearchBuilder.getPriceTo();
//        if (priceFrom != null) {
//            where.append(" and b.rentprice >= " + priceFrom);
//        }
//        if (priceTo != null) {
//            where.append(" and b.rentprice <= " + priceTo);
//        }
//        List<String> typecode = buildingSearchBuilder.getTypecode();
//        if (typecode != null && typecode.size() != 0) {
////            String tc = typecode.stream().map(i -> "'" + i + "'").collect(Collectors.joining(","));
////            where.append(" and rt.code IN(" + tc + ")");
//
////            String tc = typecode.stream().map(i -> "'" + i + "'").collect(Collectors.joining(","));
////            where.append(" AND b.type IN (" + tc + ")");
//
//              String tc = typecode.stream().map(i -> "b.type LIKE '%" + i + "%'").collect(Collectors.joining(" OR "));
//              where.append(" AND (" + tc + ")");
//        }
//
//    }
//
//    //	@Override
//    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
//        StringBuilder sql = new StringBuilder("SELECT b.*, count(b.id) FROM building b ");
//  //      StringBuilder sql = new StringBuilder("SELECT DISTINCT b.*, FROM building b ");
//        StringBuilder join = new StringBuilder("");
//        StringBuilder where = new StringBuilder(" where 1=1");
//        buildJoinQuery(buildingSearchBuilder, join);
//        specialQuerry(buildingSearchBuilder, where);
//        nomalQuerry(buildingSearchBuilder, where);
//        sql.append(join).append(where).append(" GROUP BY b.id;");
//  //      sql.append(join).append(where).append(";");
//        System.out.println("SQL Query: " + sql.toString());
//
//        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
//        return query.getResultList();
//    }
//
//
//}