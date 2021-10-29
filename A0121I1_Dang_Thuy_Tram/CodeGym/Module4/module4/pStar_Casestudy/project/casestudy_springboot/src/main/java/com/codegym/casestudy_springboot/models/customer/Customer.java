package com.codegym.casestudy_springboot.models.customer;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private CustomerType customerType;

    @Column(length = 45)
    private String name;

    private LocalDate birthday;

    private String gender;

    @Column(length = 15)
    private String identityCard;

    @Column(length = 10)
    private String phone;

    private String email;

    private String address;
}
