package com.javaweb.service;

import java.util.List;

import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.data.domain.Pageable;

public interface IBuildingService {
    List<BuildingSearchResponse> findAll(BuildingSearchRequest params, Pageable pageable);
    void createOrupdateBuilding(BuildingDTO building);
    BuildingDTO findById(Long id);
    void deleteBuilding(Long[] ids);
    List<UserEntity> findByBuildingId( Long id);
    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
    int countTotalItems();
    int getTotalItems(String searchValue);
}
