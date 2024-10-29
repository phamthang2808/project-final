package com.javaweb.repository;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaweb.repository.custom.BuildingRepositoryCustom;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
    //    List<BuildingEntity> findByNameContainingAndWardContaining(String name, String ward);
    List<BuildingEntity> findByIdIn(Long[] ids);
   // BuildingEntity findById(Long id);
    void deleteByIdIn(Long[] ids);
}
