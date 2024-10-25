package com.javaweb.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingSearchResponse {
    private Long id;
    private String name;
    private String address;
    private Long numberOfBasement;
    private String managerName;
    private String managerPhoneNumber;
    private Long floorArea;
    private Long emptyArea;
    private String rentArea;
    private Long rentPrice;
    private Long serviceFee;
    private Long brokerageFee;

}
