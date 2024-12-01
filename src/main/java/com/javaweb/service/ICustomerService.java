package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.model.response.TransactionResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerSearchResponse> getListCustomer(CustomerSearchRequest model, Pageable pageable);
    void createOrupdateCustomer(CustomerDTO customerDTO);
    int countTotalItems();
    void deleteCustomer(Long[] ids);
    int getTotalItems(String searchValue);
    CustomerDTO findByIdAndIsActive(Long id,Long active);
    void updateAssignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO);
    void createContact(CustomerDTO customerDTO);
}
