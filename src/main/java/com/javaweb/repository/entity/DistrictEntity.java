package com.javaweb.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "district")
public class DistrictEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToMany(mappedBy = "district")
    private List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;


}
