//package com.javaweb.repository.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "building")
//public class BuildingEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "district")
//    private DistrictEntity districtEntity;
//
//    @OneToMany(mappedBy = "building")
//    private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
//
//    public List<RentAreaEntity> getRentAreaEntities() {
//        return rentAreaEntities;
//    }
//
//    public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
//        this.rentAreaEntities = rentAreaEntities;
//    }
//
//    public DistrictEntity getDistrict() {
//        return districtEntity;
//    }
//
//    public void setDistrict(DistrictEntity district) {
//        this.districtEntity = district;
//    }
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "ward")
//    private String ward;
//
//    @Column(name = "street")
//    private String street;
//
//    @Column(name = "numberofbasement")
//    private Long numberOfBasement;
//
//    @Column(name = "structure")
//    private String structure;
//
//    @Column(name = "level")
//    private String level;
//
//    @Column(name = "direction")
//    private String direction;
//
//    @Column(name = "rentprice", nullable = false)
//    private Long rentprice;
//
//    @Column(name = "rentpricedescription")
//    private String rentPriceDescription;
//
//    @Column(name = "managername")
//    private String managerName;
//
//    @Column(name = "managerphone")
//    private String managerPhoneNumber;
//
//    @Column(name = "floorarea")
//    private long floorarea;
//
//    @Column(name = "servicefee")
//    private Integer serviceFee;
//
//    @Column(name = "carfee")
//    private String carFee;
//
//    @Column(name = "motofee")
//    private String motoFee;
//
//    @Column(name = "brokeragefee")
//    private double brokerageFee;
//
//    @Column(name = "type")
//    private String type;
//
//    @Column(name = "overtimefee")
//    private String overtimeFee;
//
//    @Column(name = "waterfee")
//    private String waterfee;
//
//    @Column(name = "electricityfee")
//    private String electricityFee;
//
//    @Column(name = "deposit")
//    private String deposit;
//
//    @Column(name = "payment")
//    private String payment;
//
//    @Column(name = "renttime")
//    private String rentTime;
//
//    @Column(name = "decorationtime")
//    private String decorationTime;
//
//    @Column(name = "rent_area")
//    private String rentArea;
//
//    @Column(name = "note")
//    private String note;
//
//    @Column(name = "linkofbuilding")
//    private String linkofbuilding;
//
//    @Column(name = "map")
//    private String map;
//
//    @Column(name = "avatar")
//    private String avatar;
//
//    @Column(name = "createddate")
//    private String createddate;
//
//    @Column(name = "modifiedby")
//    private String modifiedby;
//
//}
