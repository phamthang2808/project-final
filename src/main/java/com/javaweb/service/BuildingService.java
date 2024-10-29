package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.entity.AssignmentBuildingEntity;
import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(Map<String, String> params, List<String> typeCode);
    void createOrupdateBuilding(BuildingDTO building);
    BuildingDTO findById(Long id);
    void deleteBuilding(Long[] ids);
    List<UserEntity> findByBuildingId( Long id);
    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
