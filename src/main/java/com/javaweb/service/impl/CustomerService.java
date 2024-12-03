package com.javaweb.service.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.converter.CustomerSearchBuilderConverter;
import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.*;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.model.response.TransactionResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.ICustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerSearchBuilderConverter customerBuilderConverter;

    @Autowired
    CustomerConverter customerConverter;

    @Autowired
    TransactionConverter transactionConverter;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<CustomerSearchResponse> getListCustomer(CustomerSearchRequest model, Pageable pageable) {
        CustomerSearchBuilder customerSearchBuilder = customerBuilderConverter.toCustomerSearchBuilder(model);
        List<CustomerEntity> customerEntities = customerRepository.findAll(customerSearchBuilder, pageable);

        List<CustomerSearchResponse> CustomerSearchResponses = new ArrayList<>();
        for(CustomerEntity it : customerEntities) {
            CustomerSearchResponse customerSearchResponse = customerConverter.converterToCustomerResponseDTO(it);
            CustomerSearchResponses.add(customerSearchResponse);
        }
        return CustomerSearchResponses;
    }

    @Override
    public int countTotalItems() {
        return customerRepository.countTotalItem();
    }

    @Override
    public void deleteCustomer(Long[] ids) {
        List<CustomerEntity> customerEntities = customerRepository.findByIdIn(ids);
        for(CustomerEntity it : customerEntities) {
            it.setIsActive(0L);
        }
        customerRepository.saveAll(customerEntities);
    }

    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
//        if (StringUtils.isNotBlank(searchValue)) {
//            totalItem = (int) userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0);
//        } else {
//            totalItem = (int) userRepository.countByStatusNot(0);
//        }
        return totalItem;
    }

    @Override
    public void createOrupdateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.converterToCustomerEntity(customerDTO);
        customerRepository.save(customerEntity);
    }

    @Override
    public CustomerDTO findByIdAndIsActive(Long id, Long active) {
        CustomerEntity customerEntity = customerRepository.findByIdAndIsActive(id, active);
        CustomerDTO customerDTO = customerConverter.converterToCustomerDTO(customerEntity);
        return customerDTO;
    }

    @Override
    public void updateAssignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();

        if (assignmentCustomerDTO.getCustomerId() != null) {
            customerEntity= customerRepository.getOne(assignmentCustomerDTO.getCustomerId());
        }
        List<UserEntity> userEntities = userRepository.findByIdIn(assignmentCustomerDTO.getStaffs());
        customerEntity.setUserEntities(userEntities);
        customerRepository.save(customerEntity);
    }

    @Override
    public void createContact(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.converterToCustomerContactEntity(customerDTO);
        customerRepository.save(customerEntity);
    }


}
