package com.javaweb.controller.admin;


import com.javaweb.constant.SystemConstant;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController(value = "buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute(name = "modelSearch") BuildingSearchRequest params,
                                     HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        modelAndView.addObject("district", DistrictCode.type());
        modelAndView.addObject("renttype", BuildingType.type());
        modelAndView.addObject("staffs", userService.listStaff());
        //xuong db lay du lieu
        BuildingSearchResponse model = new BuildingSearchResponse();
        DisplayTagUtils.of(request, model);
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            params.setStaffId(SecurityUtils.getPrincipal().getId());
        }
        List<BuildingSearchResponse> buildings = buildingService.findAll(params,
                PageRequest.of(model.getPage() - 1, model.getMaxPageItems()));
//        modelAndView.addObject("listBuiling", buildings);
        model.setListResult(buildings);
        model.setTotalItems(buildingService.countTotalItems());
        modelAndView.addObject(SystemConstant.MODEL, model);
        initMessageResponse(modelAndView, request);
        return modelAndView;
    }

    @GetMapping("/admin/building-edit-{id}")
    public ModelAndView buildingEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            UserEntity userEntity = userRepository.findById(SecurityUtils.getPrincipal().getId()).get();
            if(!buildingEntity.getStaffs().contains(userEntity)){
                  return new ModelAndView("/view/web/errornotfound");
            }
        }

        modelAndView.addObject("district", DistrictCode.type ());
        modelAndView.addObject("renttype", BuildingType.type());

        //xuong service dung findById
        BuildingDTO buildingDTO = buildingService.findById(id);
         modelAndView.addObject("buildingEdit", buildingDTO);
        return modelAndView;
    }

    @GetMapping("/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute(name = "buildingEdit") BuildingDTO buildingDTO) {
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("district", DistrictCode.type());
        modelAndView.addObject("renttype", BuildingType.type());
        return modelAndView;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = MessageUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }


}

