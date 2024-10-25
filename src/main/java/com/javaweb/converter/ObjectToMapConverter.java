package com.javaweb.converter;

import com.javaweb.model.request.BuildingSearchRequest;

import java.util.HashMap;
import java.util.Map;

public class ObjectToMapConverter {
    public Map<String, String> convertToMap(BuildingSearchRequest params) {
        Map<String, String> map = new HashMap<>();

        if (params.getName() != null) {
            map.put("name", params.getName());
        }
        if (params.getFloorArea() != null) {
            map.put("floorArea", params.getFloorArea().toString());
        }
        if (params.getDistrict() != null) {
            map.put("district", params.getDistrict());
        }
        if (params.getWard() != null) {
            map.put("ward", params.getWard());
        }
        if (params.getStreet() != null) {
            map.put("street", params.getStreet());
        }
        if (params.getNumberOfBasement() != null) {
            map.put("numberOfBasement", params.getNumberOfBasement().toString());
        }
        if (params.getDirection() != null) {
            map.put("direction", params.getDirection());
        }
        if (params.getLevel() != null) {
            map.put("level", params.getLevel());
        }
        if (params.getAreaFrom() != null) {
            map.put("areaFrom", params.getAreaFrom().toString());
        }
        if (params.getAreaTo() != null) {
            map.put("areaTo", params.getAreaTo().toString());
        }
        if (params.getRentPriceFrom() != null) {
            map.put("rentPriceFrom", params.getRentPriceFrom().toString());
        }
        if (params.getRentPriceTo() != null) {
            map.put("rentPriceTo", params.getRentPriceTo().toString());
        }
        if (params.getManagerName() != null) {
            map.put("managerName", params.getManagerName());
        }
        if (params.getManagerPhone() != null) {
            map.put("managerPhone", params.getManagerPhone());
        }
        if (params.getStaffId() != null) {
            map.put("staffId", params.getStaffId().toString());
        }
        if (params.getTypeCode() != null && !params.getTypeCode().isEmpty()) {
            map.put("typeCode", String.join(",", params.getTypeCode()));
        }
        return map;
    }

}
