//package com.javaweb.converter;
//
//import java.util.stream.Collectors;
//
//
//import com.javaweb.model.response.BuildingSearchResponse;
//import com.javaweb.repository.entity.BuildingEntity;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BuildingConverter {
//    //	@Autowired
////	private RentAreaRepository rentAreaRepository;
////	@Autowired
////	private DistrictRepository districtRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//    public BuildingSearchResponse converterTOBuilingResponseDTO(BuildingEntity it) {
//        BuildingSearchResponse buildingSearchRespone = modelMapper.map(it, BuildingSearchResponse.class);
//        String districtName = (it.getDistrictEntity() != null) ? it.getDistrictEntity().getName() : "district null";
//        buildingSearchRespone.setAddress(it.getStreet() + "," + it.getWard() + "," + districtName);
//
//        String rentArea = (it.getRentAreaEntities() != null) ? it.getRentAreaEntities().stream()
//                .map(i -> i.getValue().toString()).collect(Collectors.joining(",")) : "rent area null";
//        buildingSearchRespone.setRentArea(rentArea);
//        return buildingSearchRespone;
//    }
//}
