package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
public class BuildingDTO extends AbstractDTO {
    private Long id;
    @NotBlank(message = "Name Building can not be Blank")
    private String name;
    private String street;
    private String ward;
    private String district;
    private Long numberOfBasement;
    private Long floorArea;
    private String level;
    @Size(min = 1,message = "Type code must be size >= 1")
    private List<String> typeCode;
    private String overtimeFee;
    private String electricityFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationTime;
    private String rentPriceDescription;
    private String carFee;
    private String motoFee;
    private String structure;
    private String direction;
    private String rentArea;
    private String note;
    private String managerName;
    private String managerPhone;
//    @Min(value = 0, message = "Rent Price must be >= 0")
    private List<Long> rentPrice;
    private String serviceFee;
    private double brokerageFee;
    private String image;
    private String imageBase64;
    private String imageName;

    private Map<String, String> buildingDTOs = new HashMap<>();
}
