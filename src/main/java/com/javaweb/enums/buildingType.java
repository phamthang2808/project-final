package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum buildingType {
    TANG_TRET("Tầng Trệt"),
    NGUYEN_CAN("Nguyên Căn"),
    NOI_THAT("Nội Thất");

    private final String name;

    buildingType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static Map<String, String> type(){
        Map<String, String> listtType = new LinkedHashMap<>();
        for(buildingType item : buildingType.values()) {
            listtType.put(item.toString(), item.getName());
        }
        return listtType;
    }

}
