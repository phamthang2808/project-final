package com.javaweb.api.admin;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/buildings")
public class BuildingAPI {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    private ResponseEntity<?> createOrUpdateBuilding(
            @Valid @RequestBody BuildingDTO buildingDTO, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList());
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setMessage("Failed");
                responseDTO.setDetail(errorMessages);
                return ResponseEntity.badRequest().body(responseDTO);
            }
            //xuong service repository lay du lieu
            buildingService.createOrupdateBuilding(buildingDTO);
            return ResponseEntity.ok("Building information saved successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{ids}")
    private Object deleteBuilding(@PathVariable Long[] ids){
        //xuong service
        buildingService.deleteBuilding(ids);
        return new String("deleteBuilding successfully.");
    }

    @GetMapping("/{id}")
    private Object loadStaffs(@PathVariable Long id){
        //xuong service.....
        List<UserEntity> userEntities = UserRepository.findByStatusAndRoles_Code(1,"STAFF"); // all staff
        //BuildingEntity tuong ung voi id
        List<UserEntity> assigmentStaffs = buildingService.findByBuildingId(id);

        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities){ // duyet
            StaffResponseDTO staffResponseDTO  = new StaffResponseDTO();
            staffResponseDTO.setStaffId(userEntity.getId());
            staffResponseDTO.setUserName(userEntity.getUserName());
            if(assigmentStaffs.contains(userEntity)){
                staffResponseDTO.setChecked("checked");
            }else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;
    }

    @PutMapping("/staffs")
    private Object updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO){
        //xuong service
        buildingService.updateAssignmentBuilding(assignmentBuildingDTO);
        return new String("update AssignmentBuilding successfully.");
    }
}
