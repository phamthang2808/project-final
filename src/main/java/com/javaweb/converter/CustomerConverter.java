package com.javaweb.converter;

import com.javaweb.constant.SystemConstant;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.security.utils.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerSearchResponse converterToCustomerResponseDTO(CustomerEntity it) {
        CustomerSearchResponse customerSearchResponse = modelMapper.map(it, CustomerSearchResponse.class);
        return customerSearchResponse;
    }

    public CustomerDTO converterToCustomerDTO(CustomerEntity it) {
        CustomerDTO customerDTO = modelMapper.map(it, CustomerDTO.class);
        return customerDTO;
    }

    public CustomerEntity converterToCustomerEntity(CustomerDTO it) {
        CustomerEntity customerEntity = modelMapper.map(it, CustomerEntity.class);
        customerEntity.setIsActive(1L);
        customerEntity.setCreatedBy(SecurityUtils.getPrincipal().getUsername());
        if (it.getId() != null) {
            CustomerEntity customer = customerRepository.findById(it.getId()).get();
            customerEntity.setCreatedDate(customer.getCreatedDate());
            customerEntity.setCreatedBy(customer.getCreatedBy());
            //giu nguyen cac userentity ManytoMany voi customer tranh mat du lieu bang trung gian
            List<UserEntity>  currentUsers = customer.getUserEntities();
            if(currentUsers != null && currentUsers.size() > 0) {
                customerEntity.setUserEntities(currentUsers);
            }
        }
        return customerEntity;
    }

    public CustomerEntity converterToCustomerContactEntity(CustomerDTO it) {
        CustomerEntity customerEntity = modelMapper.map(it, CustomerEntity.class);
        customerEntity.setIsActive(1L);
        if (SecurityUtils.getAuthorities().contains(SystemConstant.MANAGER_ROLE) || SecurityUtils.getAuthorities().contains(SystemConstant.STAFF_ROLE)) {
            customerEntity.setCreatedBy(SecurityUtils.getPrincipal().getUsername());
        } else {
            customerEntity.setCreatedBy("anonymousUser");
        }
        customerEntity.setStatus("CHUA_XU_LY");
        return customerEntity;
    }
}
