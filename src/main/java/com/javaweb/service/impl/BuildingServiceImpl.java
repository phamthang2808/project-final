package com.javaweb.service.impl;

import java.util.*;

import javax.transaction.Transactional;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.converter.ObjectToMapConverter;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.*;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaweb.service.BuildingService;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private BuildingSearchBuilderConverter builderConverter;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest params, List<String> typecode) {
        ObjectToMapConverter objectToMapConverter = new ObjectToMapConverter();
       Map<String, String> searchParams = objectToMapConverter.convertToMap(params);

       //convert ->Object
        BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(searchParams, typecode);// map
        List<BuildingEntity> BuildingEntities = buildingRepository.findAll(buildingSearchBuilder);

        //chuyen entity sang dto
        List<BuildingSearchResponse> BuildingSearchRespones = new ArrayList<>();
        for (BuildingEntity it : BuildingEntities) {
            BuildingSearchResponse buildingSearchRespones = buildingConverter.converterToBuilingResponseDTO(it);
            BuildingSearchRespones.add(buildingSearchRespones);
        }
        return BuildingSearchRespones;
    }

    @Override
    public void createOrupdateBuilding(BuildingDTO building) {
//        BuildingEntity buildingEntity = buildingConverter.converterToBuildingEntity(building);
        BuildingEntity buildingEntity = modelMapper.map(building, BuildingEntity.class);
        if (building.getId() != null) {
     //       buildingEntity = buildingRepository.getOne(building.getId());
            rentAreaRepository.deleteAllByBuilding(buildingEntity);
        }
//        DistrictEntity districtEntity = districtRepository.findById(building.getDistrict()).get();
//        buildingEntity.setDistrict(districtEntity);
        buildingRepository.save(buildingEntity);
        //vi du them du lieu co thuoc tinh o bang khac 1 building co nhieu rentarea
        for (Long value : building.getRentArea()) {
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntity.setValue(value);
            rentAreaRepository.save(rentAreaEntity);
        }
    }

    @Override
    public BuildingDTO findById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();// get id
        BuildingDTO buildingDTO = buildingConverter.converterToBuilingDTO(buildingEntity);// convert entity -> dto
        return buildingDTO;
    }

    @Override
    public void deleteBuilding(Long[] ids) {
        List<BuildingEntity> buildingEntities = buildingRepository.findByIdIn(ids);
        rentAreaRepository.deleteAllByBuildingIn(buildingEntities);
        assignmentBuildingRepository.deleteAllByBuildingIn(buildingEntities);
        buildingRepository.deleteByIdIn(ids);
    }

//    @Override
//    public List<UserEntity> findByBuildingId(Long id) {
//        List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findByBuildingId(id).get();
//        List<UserEntity> userEntities = new ArrayList<>();
//        for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntities) {
//            UserEntity userEntity = assignmentBuildingEntity.getStaffs();//tra ve doi tuong
//            if (userEntity != null) {
//                userEntities.add(userEntity);
//            }
//        }
//        return userEntities;
//    }

    @Override
    public List<UserEntity> findByBuildingId(Long id) {
        List<AssignmentBuildingEntity> liststaffById = new ArrayList<>();
        List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findAll();

        for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntities) {
            if (assignmentBuildingEntity.getBuilding().getId().equals(id)) {
                liststaffById.add(assignmentBuildingEntity);
            }
        }
        List<UserEntity> userEntities = new ArrayList<>();
        for (AssignmentBuildingEntity assignmentBuildingEntity : liststaffById) {
            UserEntity userEntity = assignmentBuildingEntity.getStaffs();//tra ve doi tuong
            if (userEntity != null) {
                userEntities.add(userEntity);
            }
        }
        return userEntities;
    }

    @Override
    public void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();

        if (assignmentBuildingDTO.getBuildingId() != null) {
            buildingEntity = buildingRepository.getOne(assignmentBuildingDTO.getBuildingId());
        }
        if (buildingEntity != null) {
            assignmentBuildingRepository.deleteAllByBuildingId(buildingEntity.getId());
        }
        if (assignmentBuildingDTO.getBuildingId() != null) {
            List<UserEntity> userEntities = new ArrayList<>();
            for (Long value : assignmentBuildingDTO.getStaffs()) {
                UserEntity userEntity = userRepository.findById(value).get();
                userEntities.add(userEntity);
            }
            for (UserEntity userEntity : userEntities) {
                AssignmentBuildingEntity assignmentBuildingEntity1 = new AssignmentBuildingEntity();
                assignmentBuildingEntity1.setBuilding(buildingEntity);
                assignmentBuildingEntity1.setStaffs(userEntity);
                assignmentBuildingRepository.save(assignmentBuildingEntity1);
            }
        }
    }


}
