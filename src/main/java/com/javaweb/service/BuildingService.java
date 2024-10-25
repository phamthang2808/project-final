package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(Map<String, String> params, List<String> typeCode);
    void createOrupdateBuilding(BuildingDTO building);
    void deleteBuilding(Integer[] ids);
  //  void createBuilding(BuildingDTO buildingDTO);
}
