package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import org.springframework.stereotype.Component;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtils;

@Component
public class BuildingSearchBuilderConverter {
//    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, String> params, List<String> typeCode) {
//        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
//                .setName(MapUtils.getObject(params, "name", String.class))
//                .setFloorArea(MapUtils.getObject(params, "floorArea", Long.class))
//                .setDistrict(MapUtils.getObject(params, "district", String.class))
//                .setWard(MapUtils.getObject(params, "ward", String.class))
//                .setStreet(MapUtils.getObject(params, "street", String.class))
//                .setNumberOfBasement(MapUtils.getObject(params, "numberOfBasement", Long.class))
//                .setAreaFrom(MapUtils.getObject(params, "areaFrom", Long.class))
//                .setAreaTo(MapUtils.getObject(params, "areaTo", Long.class))
//                .setPriceFrom(MapUtils.getObject(params, "rentPriceFrom", Long.class))
//                .setPriceTo(MapUtils.getObject(params, "rentPriceTo", Long.class))
//                .setManagerName(MapUtils.getObject(params, "managerName", String.class))
//                .setManagerPhone(MapUtils.getObject(params, "managerPhone", String.class))
//                .setStaffId(MapUtils.getObject(params, "staffId", Long.class))
//                .setTypecode(typeCode)
//                .build();
//
//        return buildingSearchBuilder;
//    }

    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUtils.getObject(buildingSearchRequest.getName(), String.class))
                .setFloorArea(MapUtils.getObject(buildingSearchRequest.getFloorArea(), Long.class))
                .setStreet(MapUtils.getObject(buildingSearchRequest.getStreet(), String.class))
                .setWard(MapUtils.getObject(buildingSearchRequest.getWard(), String.class))
                .setDistrict(MapUtils.getObject(buildingSearchRequest.getDistrict(), String.class))
                .setNumberOfBasement(MapUtils.getObject(buildingSearchRequest.getNumberOfBasement(), Long.class))
                .setTypecode(buildingSearchRequest.getTypeCode())
                .setManagerName(MapUtils.getObject(buildingSearchRequest.getManagerName(), String.class))
                .setManagerPhone(MapUtils.getObject(buildingSearchRequest.getManagerPhone(), String.class))
                .setPriceFrom(MapUtils.getObject(buildingSearchRequest.getRentPriceFrom(), Long.class))
                .setPriceTo(MapUtils.getObject(buildingSearchRequest.getRentPriceTo(), Long.class))
                .setAreaFrom(MapUtils.getObject(buildingSearchRequest.getAreaFrom(), Long.class))
                .setAreaTo(MapUtils.getObject(buildingSearchRequest.getAreaTo(), Long.class))
                .setStaffId(MapUtils.getObject(buildingSearchRequest.getStaffId(), Long.class))
                .build();
        return buildingSearchBuilder;
    }

}
