package com.javaweb.repository;

import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.entity.RentAreaEntity;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    //    List<RentAreaEntity> findValue(Long buildingId);
    void deleteAllByBuilding(BuildingEntity buildingEntity );
    void deleteAllByBuildingIn(List<BuildingEntity> buildingEntity);
}
