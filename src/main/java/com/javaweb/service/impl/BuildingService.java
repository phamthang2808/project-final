package com.javaweb.service.impl;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.transaction.Transactional;
import  java.util.Base64;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.converter.ObjectToMapConverter;
import com.javaweb.converter.RentAreaConverter;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.*;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.UploadFileUtils;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BuildingService implements IBuildingService {

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

    @Autowired
    RentAreaConverter rentAreaConverter;

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest params, Pageable pageable) {
        BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(params);// map
        List<BuildingEntity> BuildingEntities = buildingRepository.findAll(buildingSearchBuilder, pageable);

        //chuyen entity sang dto
        List<BuildingSearchResponse> BuildingSearchRespones = new ArrayList<>();
        for (BuildingEntity it : BuildingEntities) {
            BuildingSearchResponse buildingSearchRespones = buildingConverter.converterToBuilingResponseDTO(it);
            BuildingSearchRespones.add(buildingSearchRespones);
        }
        return BuildingSearchRespones;
    }

    @Override
    public int countTotalItems() {
        return buildingRepository.countTotalItem();
    }

    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
        if (StringUtils.isNotBlank(searchValue)) {
            totalItem = (int) userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0);
        } else {
            totalItem = (int) userRepository.countByStatusNot(0);
        }
        return totalItem;
    }

    @Override
    public void createOrupdateBuilding(BuildingDTO building) {
        BuildingEntity buildingEntity = buildingConverter.converterToBuildingEntity(building);

        List<RentAreaEntity> rentAreaEntities = rentAreaConverter.toRentAreaEntity(building, buildingEntity);
        buildingEntity.setRentAreaEntities(rentAreaEntities);

        if (building.getId() != null) {
            rentAreaRepository.deleteAllByBuilding(buildingEntity);
            BuildingEntity buildingEntityOld = buildingRepository.findById(buildingEntity.getId()).get();
            if(buildingEntityOld.getAvatar() != null && !buildingEntityOld.getAvatar().isEmpty()){
                buildingEntity.setAvatar(buildingEntityOld.getAvatar());
            }
        }
        saveThumbnail(building, buildingEntity);

        buildingRepository.save(buildingEntity);
    }

    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (buildingDTO.getImageBase64() != null) {
            if (buildingEntity.getAvatar() != null) {
                if (!path.equals(buildingEntity.getAvatar())) {
                    File file = new File("C://home/office" + buildingEntity.getAvatar());
                    file.delete();
                }
            }
            String base64Data = buildingDTO.getImageBase64();
            if(base64Data.contains(",")){
                base64Data = base64Data.split(",")[1];
            }
            //byte[] bytes = Base64.decodeBase64(base64Data.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = Base64.getDecoder().decode(base64Data.getBytes(StandardCharsets.UTF_8));

            UploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setAvatar(path);
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
//        List<BuildingEntity> buildingEntities = buildingRepository.findByIdIn(ids);
//      //  rentAreaRepository.deleteAllByBuildingIn(buildingEntities);
//        assignmentBuildingRepository.deleteAllByBuildingIn(buildingEntities);
        buildingRepository.deleteByIdIn(ids);
    }

    @Override
    public List<UserEntity> findByBuildingId(Long id) {
//        List<AssignmentBuildingEntity> liststaffById = new ArrayList<>();
//        List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findAll();
//
//        for (AssignmentBuildingEntity assignmentBuildingEntity : assignmentBuildingEntities) {
//            if (assignmentBuildingEntity.getBuilding().getId().equals(id)) {
//                liststaffById.add(assignmentBuildingEntity);
//            }
//        }
//        List<UserEntity> userEntities = userRepository.findByAssignmentBuildingEntitiesIn(liststaffById);
//        return userEntities;
        return null;
    }

    @Override
    public void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();

        if (assignmentBuildingDTO.getBuildingId() != null) {
            buildingEntity = buildingRepository.getOne(assignmentBuildingDTO.getBuildingId());
        }
//        if (buildingEntity != null) {
//            assignmentBuildingRepository.deleteAllByBuildingId(buildingEntity.getId());
//        }
            List<UserEntity> userEntities = userRepository.findByIdIn(assignmentBuildingDTO.getStaffs());
//            for (UserEntity userEntity : userEntities) {
//                AssignmentBuildingEntity assignmentBuildingEntity1 = new AssignmentBuildingEntity();
//                assignmentBuildingEntity1.setBuilding(buildingEntity);
//                assignmentBuildingEntity1.setStaffs(userEntity);
//                assignmentBuildingRepository.save(assignmentBuildingEntity1);
//            }
        buildingEntity.setStaffs(userEntities);
        buildingRepository.save(buildingEntity);
    }

}
