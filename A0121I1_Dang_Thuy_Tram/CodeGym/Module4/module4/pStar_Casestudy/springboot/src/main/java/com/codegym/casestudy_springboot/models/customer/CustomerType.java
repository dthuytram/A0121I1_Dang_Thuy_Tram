package com.codegym.casestudy_springboot.models.customer;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;
}
