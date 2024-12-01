package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.repository.custom.TransactionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>, TransactionRepositoryCustom {
    List<TransactionEntity> findByCodeAndCustomerEntity_Id(String code, Long id);
    void deleteById(Long id);
}
