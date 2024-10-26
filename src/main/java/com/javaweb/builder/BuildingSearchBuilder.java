package com.javaweb.builder;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class BuildingSearchBuilder {
    private String name;
    private Long floorArea;
    private String district;
    private String ward;
    private String street;
    private Long numberOfBasement;
    private Long areaFrom;
    private Long areaTo;
    private Long priceFrom;
    private Long priceTo;
    private String managerName;
    private String managerPhoneNumber;
    private Long staffId;
    private List<String> typecode = new ArrayList<>();

    public BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.ward = builder.ward;
        this.street = builder.street;
        this.district = builder.district;
        this.numberOfBasement = builder.numberOfBasement;
        this.typecode = builder.typecode;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.priceFrom = builder.priceFrom;
        this.priceTo = builder.priceTo;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.staffId = builder.staffId;
    }

    public static class Builder{
        public List<String> typecode;
        private String name;
        private Long floorArea;
        private String district;
        private String ward;
        private String street;
        private Long numberOfBasement;
        private Long areaFrom;
        private Long areaTo;
        private Long priceFrom;
        private Long priceTo;
        private String managerName;
        private String managerPhoneNumber;
        private Long staffId;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setFloorArea(Long floorArea) {
            this.floorArea = floorArea;
            return this;
        }
        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }
        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }
        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setNumberOfBasement(Long numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }
        public Builder setAreaFrom(Long areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }
        public Builder setAreaTo(Long areaTo) {
            this.areaTo = areaTo;
            return this;
        }
        public Builder setPriceFrom(Long priceFrom) {
            this.priceFrom = priceFrom;
            return this;
        }
        public Builder setPriceTo(Long priceTo) {
            this.priceTo = priceTo;
            return this;
        }
        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }
        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }
        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setTypecode(List<String> typecode) {
            this.typecode = typecode;
            return this;
        }
        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }

    }
}
