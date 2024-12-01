package com.javaweb.api.admin;


import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TransactionAPI {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    private ResponseEntity<?> addOrUpdateTransaction(
            @Valid @RequestBody TransactionDTO transactionDTO, BindingResult bindingResult){
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
            transactionService.addOrUpdateTransaction(transactionDTO);
            ResponseDTO successResponse = new ResponseDTO();
            successResponse.setMessage("successfully!");
            return ResponseEntity.ok(successResponse);
        }catch (Exception e){
            ResponseDTO errorResponse = new ResponseDTO();
            errorResponse.setMessage("Failed!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping("/deleteTransaction-{id}")
    private Object deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return new String("deleteTransaction successfully!");
    }
}
