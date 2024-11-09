package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentAreaConverter {
    public List<RentAreaEntity> toRentAreaEntity(BuildingDTO building, BuildingEntity buildingEntity){
        List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
        for(Long value : building.getRentArea()){
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntity.setValue(value);
            rentAreaEntities.add(rentAreaEntity);
        }
        return rentAreaEntities;
    }

}
