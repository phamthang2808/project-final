package com.javaweb.api.admin;
import com.javaweb.converter.ObjectToMapConverter;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Transactional
@RequestMapping("/api/buildings")
public class BuildingAPI {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private BuildingService buildingService;

    @PersistenceContext
    private EntityManager entityManager;

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
//            xuong service repository lay du lieu
//                buildingService.createBuilding(buildingDTO);
//              buildingService.createOrupdateBuilding(buildingDTO);
            return ResponseEntity.ok("");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{ids}")
    private Object deleteBuilding(@PathVariable List<String> ids){
//        buildingService.deleteBuilding(ids);
        //xuong service
        return new String("okkk");
    }

    @GetMapping("/{id}")
    private Object loadStaffs(@PathVariable Long id){
//        List<BuildingResponseDTO> BuildingResponseDTOs = buildingService.findAll(params, typecode);
//        return BuildingResponseDTOs;
        //xuong service.....
        List<UserEntity> userEntities = UserRepository.findByStatusAndRoles_Code(1,"STAFF"); // all staff
        //BuildingEntity tuong ung voi id
        List<UserEntity> assigmentStaffs = new ArrayList<>();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
//        for(UserEntity userEntity : userEntities){
//            StaffResponseDTO staffResponseDTO  = new StaffResponseDTO();
//            staffResponseDTO.setStaffId(userEntity.getId());
//            staffResponseDTO.setUserName(userEntity.getUserName());
//            if(assigmentStaffs.contains(userEntity)){
//                staffResponseDTO.setChecked("checked");
//            }else {
//                staffResponseDTO.setChecked("");
//            }
//            staffResponseDTOS.add(staffResponseDTO);
//        }
         StaffResponseDTO staff1 = new StaffResponseDTO();
         staff1.setStaffId(1L);
         staff1.setUserName("Pham Thang");
         staff1.setChecked("checked");

        StaffResponseDTO staff2 = new StaffResponseDTO();
        staff2.setStaffId(2L);
        staff2.setUserName("Vo Thinh");
        staff2.setChecked("");

        StaffResponseDTO staff3 = new StaffResponseDTO();
        staff3.setStaffId(3L);
        staff3.setUserName("Minh Hoang");
        staff3.setChecked("");

        StaffResponseDTO staff4 = new StaffResponseDTO();
        staff4.setStaffId(4L);
        staff4.setUserName("Nguyen Tuan");
        staff4.setChecked("checked");

        staffResponseDTOS.add(staff1);
        staffResponseDTOS.add(staff2);
        staffResponseDTOS.add(staff3);
        staffResponseDTOS.add(staff4);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;
    }

    @PutMapping("/staffs")
    private Object updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO){
        //xuong service
        return new String("okkeeee");
    }
}
