package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.TransactionResponseDTO;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    TransactionConverter transactionConverter;

    @Override
    public List<TransactionResponseDTO> findByCodeAndCustomerId(String code, Long id) {
        List<TransactionEntity> transactionEntity = transactionRepository.findByCodeAndCustomerEntity_Id(code,id);
        List<TransactionResponseDTO> transactionResponseDTOs = new ArrayList<>();
        for(TransactionEntity it : transactionEntity){
            TransactionResponseDTO transactionResponseDTO = transactionConverter.converterToTransactionResponseDTO(it);
            transactionResponseDTOs.add(transactionResponseDTO);
        }

        return transactionResponseDTOs;
    }

    @Override
    public void addOrUpdateTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = transactionConverter.converterToTransactionEntity(transactionDTO);
        transactionRepository.save(transactionEntity);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
