//package com.javaweb.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "assginmentcustomer")
//
//public class AssignmentCustomerEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customerid")
//    private CustomerEntity customerEntity;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "staffid")
//    private UserEntity userEntity;
//}
