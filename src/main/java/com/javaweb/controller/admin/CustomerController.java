package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.enums.Status;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.model.response.TransactionResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.service.impl.TransactionService;
import com.javaweb.service.impl.UserService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@RestController(value = "customersControllerOfAdmin")
public class CustomerController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = "/admin/customer-list")
    public ModelAndView customerList(@ModelAttribute(name = "modelSearch") CustomerSearchRequest customerSearchRequest,
                                     HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        CustomerSearchResponse customerSearchResponse = new CustomerSearchResponse();
        DisplayTagUtils.of(request, customerSearchResponse);
        mav.addObject("statusCode", Status.type());
        mav.addObject("staffs", userService.listStaff());

        if (SecurityUtils.getAuthorities().contains(SystemConstant.STAFF_ROLE)) {
            customerSearchRequest.setStaffId((SecurityUtils.getPrincipal().getId()));
        }
        List<CustomerSearchResponse> customers = customerService.getListCustomer(customerSearchRequest, PageRequest.of(customerSearchResponse.getPage() - 1, customerSearchRequest.getMaxPageItems()));

        Map<String, String> statusMap = Status.type();
        customers.forEach(customer -> {
            if (customer.getStatus() != null) {
                customer.setStatus(statusMap.get(customer.getStatus())); // Chuyển từ key sang value
            }
        });
        customerSearchRequest.setListResult(customers);
        customerSearchRequest.setTotalItems(customerService.countTotalItems());
        customerSearchRequest.setMaxPageItems(customerSearchRequest.getMaxPageItems());
        mav.addObject("customers", customerSearchRequest);
        initMessageResponse(mav, request);
        return mav;
    }

    @GetMapping(value = "/admin/customer-edit")
    public ModelAndView customerEdit(@ModelAttribute(name = "customerEdit") CustomerDTO customerDTO) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("statusCode", Status.type());
        return mav;
    }

    @GetMapping(value = "/admin/customer-edit-{id}")
    public ModelAndView customerEdit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerEntity customer = customerRepository.findById(id).get();
        if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
            UserEntity userEntity = userRepository.findById(SecurityUtils.getPrincipal().getId()).get();
            if (!userEntity.getCustomerEntities().contains(customer)) {
                return new ModelAndView("redirect:/access-denied");
            }
        }

        CustomerDTO customerDTO = customerService.findByIdAndIsActive(id,1L);
        if(customerDTO == null){
            return new ModelAndView("/view/web/errornotfound");
        }
        customerDTO.setStatus(customerDTO.getStatus());
        mav.addObject("customerEdit", customerDTO);
        mav.addObject("statusCode", Status.type());
        mav.addObject("transactionType", TransactionType.transactionType());

        //lay 2 ds theo transaction type CSKH va DDX: findByCodeAndCustomerId
        mav.addObject("CSKH", transactionService.findByCodeAndCustomerId("CSKH", id));
        mav.addObject("DDX", transactionService.findByCodeAndCustomerId("DDX", id));
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = MessageUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }
}
