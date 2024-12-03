package com.javaweb.entity;

import com.javaweb.security.utils.SecurityUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "building", cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private List<UserEntity> staffs = new ArrayList<>();

    @Column(name = "numberofbasement")
    private Long numberOfBasement;

    @Column(name = "brokeragefee")
    private Long brokerageFee;

    @Column(name = "rentprice", nullable = false)
    private Long rentPrice;

    @Column(name = "floorarea")
    private Long floorArea;

    @Column(name = "servicefee")
    private String serviceFee;

    @Column(name = "name")
    private String name;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "structure")
    private String structure;

    @Column(name = "level")
    private String level;

    @Column(name = "direction")
    private String direction;

    @Column(name = "rentpricedescription")
    private String rentPriceDescription;

    @Column(name = "managername")
    private String managerName;

    @Column(name = "managerphone")
    private String managerPhone;

    @Column(name = "carfee")
    private String carFee;

    @Column(name = "motofee")
    private String motoFee;

    @Column(name = "type")
    private String typeCode;

    @Column(name = "overtimefee")
    private String overtimeFee;

    @Column(name = "waterfee")
    private String waterfee;

    @Column(name = "electricityfee")
    private String electricityFee;

    @Column(name = "deposit")
    private String deposit;

    @Column(name = "payment")
    private String payment;

    @Column(name = "renttime")
    private String rentTime;

    @Column(name = "decorationtime")
    private String decorationTime;

    @Column(name = "note")
    private String note;

    @Column(name = "linkofbuilding")
    private String linkofbuilding;

    @Column(name = "map")
    private String map;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "createddate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "createdby")
    @CreatedBy
    private String createdBy;

    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifiedDate;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
        this.createdBy = SecurityUtils.getPrincipal().getUsername();
        this.modifiedBy = null;
        this.modifiedDate = null;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedBy = SecurityUtils.getPrincipal().getUsername();
        this.modifiedDate = new Date();
    }
}
