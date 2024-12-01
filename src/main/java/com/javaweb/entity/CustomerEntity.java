package com.javaweb.entity;

import com.javaweb.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname",nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "demand")
    private String demand;

    @Column(name = "status")
    private String status;

    @Column(name = "is_active", nullable = false)
    private Long isActive;

    @Column(name = "createdby")
    private String createdBy;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentcustomer",
            joinColumns = @JoinColumn(name = "customerid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private List<UserEntity> userEntities = new ArrayList<>();

    @OneToMany(mappedBy="customerEntity", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TransactionEntity> transactionEntities = new ArrayList<>();

}
