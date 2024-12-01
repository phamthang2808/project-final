package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum BuildingType {
    TANG_TRET("Tầng Trệt"),
    NGUYEN_CAN("Nguyên Căn"),
    NOI_THAT("Nội Thất");

    private final String name;

    BuildingType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static Map<String, String> type(){
        Map<String, String> listtType = new LinkedHashMap<>();
        for(BuildingType item : BuildingType.values()) {
            listtType.put(item.toString(), item.getName());
        }
        return listtType;
    }

}
