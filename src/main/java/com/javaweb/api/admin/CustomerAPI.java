package com.javaweb.api.admin;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.*;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private com.javaweb.repository.UserRepository UserRepository;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    private ResponseEntity<?> createOrUpdateCustomer(
            @Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setMessage("Failed");
                responseDTO.setDetail(errorMessages);
                return ResponseEntity.badRequest().body(responseDTO);
            }
            customerService.createOrupdateCustomer(customerDTO);
            return ResponseEntity.ok("Customer information saved successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    private Object loadStaffs(@PathVariable Long id){
        List<UserEntity> userEntities = UserRepository.findByStatusAndRoles_Code(1,"STAFF"); // all staff
        List<UserEntity> assigmentStaffs = userRepository.findAllByCustomerEntities_Id(id);
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            StaffResponseDTO staffResponseDTO  = new StaffResponseDTO();
            staffResponseDTO.setStaffId(userEntity.getId());
            staffResponseDTO.setUserName(userEntity.getUserName());
            if(assigmentStaffs.contains(userEntity)){
                staffResponseDTO.setChecked("checked");
            }else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;
    }

    @DeleteMapping("/{ids}")
    private Object deleteCustomer(@PathVariable Long[] ids){
        //xuong service
        customerService.deleteCustomer(ids);
        return new String("deleteCustomer successfully.");
    }

    @PutMapping("/staffs")
    private Object updateAssignmentCustomer(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO){
        //xuong service
        customerService.updateAssignmentCustomer(assignmentCustomerDTO);
        return new String("update AssignmentCustomers successfully.");
    }

    @PostMapping("/contact")
    public Object addContact(@RequestBody CustomerDTO customerDTO) {
        // Xử lý dữ liệu contactDTO
        customerService.createContact(customerDTO);
        return new String("Contact added successfully");
    }

}
