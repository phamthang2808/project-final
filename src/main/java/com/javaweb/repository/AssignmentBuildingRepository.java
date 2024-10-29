package com.javaweb.repository;

import com.javaweb.repository.entity.AssignmentBuildingEntity;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
   List<AssignmentBuildingEntity> findByBuildingId(Long buildingId);
   void deleteAllByBuildingId(BuildingEntity buildingEntity);
}
