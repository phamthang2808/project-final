package com.javaweb.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.repository.BuildingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BuildingRepository buildingRepository;

    public BuildingSearchResponse converterToBuilingResponseDTO(BuildingEntity it) {
        BuildingSearchResponse buildingSearchRespone = modelMapper.map(it, BuildingSearchResponse.class);
        String districtName = "";
        if(it.getDistrict() != null){
            try {
                districtName = DistrictCode.valueOf(it.getDistrict()).getDistrictName();
            } catch (IllegalArgumentException e) {
                districtName = " District null";
            }
        }

        buildingSearchRespone.setAddress(it.getStreet() + "," + it.getWard() + "," + districtName);

        String rentArea = (it.getRentAreaEntities() != null) ? it.getRentAreaEntities().stream()
                .map(i -> i.getValue().toString()).collect(Collectors.joining(",")) : "rent area null";
        buildingSearchRespone.setRentArea(rentArea);
        return buildingSearchRespone;
    }

    public BuildingDTO converterToBuilingDTO(BuildingEntity it) {
        BuildingDTO buildingDTO = modelMapper.map(it, BuildingDTO.class);
        // Kiểm tra diện tích thuê
        if (it.getRentAreaEntities() == null || it.getRentAreaEntities().isEmpty()) {
            throw new IllegalArgumentException("Rent area entities is null.");
        }

        List<Long> rentAreas = it.getRentAreaEntities().stream()
                .map(RentAreaEntity::getValue) // Lấy giá trị từ mỗi RentAreaEntity
                .collect(Collectors.toList()); // Chuyển đổi thành danh sách
        buildingDTO.setRentArea(rentAreas);

        if (it.getTypeCode() != null && !it.getTypeCode().isEmpty()) {
            List<String> typeCodeList = Arrays.asList(it.getTypeCode().split(","));
            buildingDTO.setTypeCode(typeCodeList);
        }
        if(it.getAvatar() != null && !it.getAvatar().isEmpty()){
            buildingDTO.setImage(it.getAvatar());
        }

        return buildingDTO;
    }

    public BuildingEntity converterToBuildingEntity(BuildingDTO it) {
        BuildingEntity buildingEntity = modelMapper.map(it, BuildingEntity.class);
        //xu ly rieng district, rentarea bi null
        if(it.getRentArea() == null || it.getRentArea().isEmpty()) {
            throw new IllegalArgumentException("Rent area DTO is empty.");
        }
        if (it.getDistrict() == null || it.getDistrict().isEmpty()) {
            throw new IllegalArgumentException("District DTO is empty.");
        }
        if (it.getTypeCode() != null && !it.getTypeCode().isEmpty()) {
            String typeCodeString = String.join(",", it.getTypeCode());
            buildingEntity.setTypeCode(typeCodeString);
        }
        BuildingEntity currentBuildingEntity;
        if(it.getId() != null){
            currentBuildingEntity = buildingRepository.findById(it.getId()).get();
            buildingEntity.setCreatedBy(currentBuildingEntity.getCreatedBy());
            buildingEntity.setCreatedDate(currentBuildingEntity.getCreatedDate());
            buildingEntity.setStaffs(currentBuildingEntity.getStaffs());
        }
        return buildingEntity;
    }
}
