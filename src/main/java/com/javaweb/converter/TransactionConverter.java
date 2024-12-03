package com.javaweb.converter;

import com.javaweb.constant.SystemConstant;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.TransactionResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.security.utils.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionResponseDTO converterToTransactionResponseDTO(TransactionEntity it){
        TransactionResponseDTO transactionResponseDTO = modelMapper.map(it, TransactionResponseDTO.class);
        return transactionResponseDTO;
    }

    public TransactionEntity converterToTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity transactionEntity;
        if (transactionDTO.getId() == null) {
            transactionEntity = new TransactionEntity();
        } else {
            transactionEntity = transactionRepository.findById(transactionDTO.getId()).get();
        }

        CustomerEntity customerEntity = customerRepository.findById(transactionDTO.getCustomerId()).get();
        transactionEntity.setCustomerEntity(customerEntity);
        transactionEntity.setCode(transactionDTO.getCode());
        transactionEntity.setNote(transactionDTO.getNote());

        return transactionEntity;
    }
}
