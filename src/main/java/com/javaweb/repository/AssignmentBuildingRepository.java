package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
   List<AssignmentBuildingEntity> findByBuildingId(Long buildingId);
   void deleteAllByBuildingId( Long id);
   void deleteAllByBuildingIn(List<BuildingEntity> buildingEntity);
}
