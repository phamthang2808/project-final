package com.javaweb.converter;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtils;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, String> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUtils.getObject(params, "name", String.class))
                .setFloorArea(MapUtils.getObject(params, "floorArea", Long.class))
                .setDistrict(MapUtils.getObject(params, "district", String.class))
                .setWard(MapUtils.getObject(params, "ward", String.class))
                .setStreet(MapUtils.getObject(params, "street", String.class))
                .setNumberOfBasement(MapUtils.getObject(params, "numberOfBasement", Long.class))
                .setAreaFrom(MapUtils.getObject(params, "areaFrom", Long.class))
                .setAreaTo(MapUtils.getObject(params, "areaTo", Long.class))
                .setPriceFrom(MapUtils.getObject(params, "rentPriceFrom", Long.class))
                .setPriceTo(MapUtils.getObject(params, "rentPriceTo", Long.class))
                .setManagerName(MapUtils.getObject(params, "managerName", String.class))
                .setManagerPhoneNumber(MapUtils.getObject(params, "managerPhone", String.class))
                .setStaffId(MapUtils.getObject(params, "staffId", Long.class))
                .setTypecode(typeCode)
                .build();

        return buildingSearchBuilder;
    }
}
