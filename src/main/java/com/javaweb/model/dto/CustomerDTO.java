package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerDTO extends AbstractDTO{
    @NotBlank(message = "Name customer can not be Blank!")
    private String name;
    private String managementStaff;

    private String phone;
    private String email;
    private String demand;
    private String status;
    private String companyName;



}
