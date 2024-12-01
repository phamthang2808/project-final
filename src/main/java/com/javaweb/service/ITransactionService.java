package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.TransactionResponseDTO;

import java.util.List;

public interface ITransactionService {
    List<TransactionResponseDTO> findByCodeAndCustomerId(String code, Long id);
    void addOrUpdateTransaction(TransactionDTO transactionDTO);
    void deleteTransaction(Long id);
}
