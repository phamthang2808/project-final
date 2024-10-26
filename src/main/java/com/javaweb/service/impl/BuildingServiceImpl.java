package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.BuildingService;
import static com.lowagie.text.Image.skip;

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

    @Override
    public List<BuildingSearchResponse> findAll(Map<String, String> params, List<String> typecode) {
        BuildingSearchBuilder buildingSearchBuilder = builderConverter.toBuildingSearchBuilder(params, typecode);
        List<BuildingEntity> BuildingEntities = buildingRepository.findAll(buildingSearchBuilder);
        //chuyen entity sang dto
        List<BuildingSearchResponse> BuildingSearchRespones = new ArrayList<>();
        for (BuildingEntity it : BuildingEntities) {
            BuildingSearchResponse buildingSearchRespones = buildingConverter.converterTOBuilingResponseDTO(it);
            BuildingSearchRespones.add(buildingSearchRespones);
        }
        return BuildingSearchRespones;
    }

    @Override
    public void createOrupdateBuilding(BuildingDTO building) {
        BuildingEntity buildingEntity = modelMapper.map(building, BuildingEntity.class);

        //sua don thuan 1 bang
//		if(building.getId() != null) {
//			buildingEntity.setId(building.getId());
//		}
        //sua co thuoc tinh bang khac
//        if(building.getId() != null) {
//            buildingEntity = buildingRepository.getOne(building.getId());
//            //muon sua thi xoa truoc roi them moi la thanh sua
//            rentAreaRepository.deleteAllByBuilding(buildingEntity);
//        }


//        DistrictEntity districtEntity = districtRepository.findById(building.getDistrictId()).get();
//        buildingEntity.setDistrict(districtEntity);
//    	muon co bang rentarea phai co khoa ngoai building id nen phai save building truoc
        buildingRepository.save(buildingEntity);
        //vi du them du lieu co thuoc tinh o bang khac 1 building co nhieu rentarea
        for(Long value : building.getRentArea()) {
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntity.setValue(value);
            rentAreaRepository.save(rentAreaEntity);
        }
    }
    @Override
    public void deleteBuilding(Integer[] ids) {
//        BuildingEntity buildingEntity = new BuildingEntity();
//        buildingEntity = buildingRepository.getOne(ids[0]);
//        rentAreaRepository.deleteAllByBuilding(buildingEntity);
//        buildingRepository.deleteByIdIn(ids);
    }



}
