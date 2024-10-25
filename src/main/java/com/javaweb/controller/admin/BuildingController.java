package com.javaweb.controller.admin;



//import com.javaweb.converter.ObjectToMapConverter;
import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
//import com.javaweb.service.BuildingService;
import com.javaweb.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService;

//    @Autowired
//    private BuildingService buildingService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute(name ="modelSearch") BuildingSearchRequest params){
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        modelAndView.addObject("district", districtCode.type());
        modelAndView.addObject("renttype", buildingType.type());
        modelAndView.addObject("staffs", userService.listStaff());
        //xuong db lay du lieu
//        ObjectToMapConverter objectToMapConverter = new ObjectToMapConverter();
//        Map<String, String> searchParams = objectToMapConverter.convertToMap(params);
//        List<BuildingSearchResponse> buildings = buildingService.findAll(searchParams, params.getTypeCode());
//        System.out.println("building size: "  + buildings.size());
//        List<BuildingSearchResponse> respones = new ArrayList<>();
//         for(BuildingSearchResponse building : buildings){
//             BuildingSearchResponse buildingSearchRespone = modelMapper.map(building, BuildingSearchResponse.class);
//             respones.add(buildingSearchRespone);
//             System.out.println("Size response: "+ respones.size());
//         }

        //dan dung vi du vai bua tu xuong data lay
        List<BuildingSearchResponse> respones = new ArrayList<>();
        BuildingSearchResponse b1 = new BuildingSearchResponse();
        b1.setId(1L);
        b1.setName("Vo Thinh");
        b1.setAddress("42 Do Quang,Thanh Khe, Da Nang");
        b1.setNumberOfBasement(3L);
        b1.setFloorArea(300L);
        b1.setManagerName("Pham Thang");
        respones.add(b1);

        BuildingSearchResponse b2 = new BuildingSearchResponse();
        b2.setId(2L);
        b2.setName("Minh Hoang");
        b2.setAddress("37 Ha Huy Giap, Hoa Cuong Nam, Hai Chau , Da Nang");
        b2.setNumberOfBasement(5L);
        b2.setFloorArea(200L);
        b2.setManagerName("Nguyen Tuan");
        respones.add(b2);
         modelAndView.addObject("listBuiling", respones);
        return modelAndView;
    }

    @GetMapping("/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute(name = "buildingEdit") BuildingDTO buildingDTO){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("district", districtCode.type());
        modelAndView.addObject("renttype", buildingType.type());
        return modelAndView;
    }

    @GetMapping("/admin/building-edit-{id}")
    public ModelAndView buildingEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("district", districtCode.type());
        modelAndView.addObject("renttype", buildingType.type());
        //xuong DB dung ham findByID de lay data toa nha hien tai =>BuildingEntity convert BuildingDTO

        //gan cung
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(id);
        buildingDTO.setName("Novotel");
        buildingDTO.setFloorArea(3L);
        List<String> typeCodes = new ArrayList<>();
        typeCodes.add("TANG_TRET");
        typeCodes.add("NGUYEN_CAN");
        buildingDTO.setTypeCode(typeCodes);
        modelAndView.addObject("buildingEdit", buildingDTO);
        return modelAndView;
    }
}

