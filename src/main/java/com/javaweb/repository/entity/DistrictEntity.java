package com.javaweb.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "district")
public class DistrictEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToMany(mappedBy = "districtEntity")
    private List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

    public List<BuildingEntity> getRentAreaEntities() {
        return buildingEntities;
    }

    public void setRentAreaEntities(List<BuildingEntity> rentAreaEntities) {
        this.buildingEntities = rentAreaEntities;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;


}
