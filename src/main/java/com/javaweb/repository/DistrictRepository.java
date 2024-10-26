package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.repository.entity.DistrictEntity;

public interface DistrictRepository extends JpaRepository<DistrictEntity,String> {
//    DistrictEntity findDistrictId(Long districtId);
}
