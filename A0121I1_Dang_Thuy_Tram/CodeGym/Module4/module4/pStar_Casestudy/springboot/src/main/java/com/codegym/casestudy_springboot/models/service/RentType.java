package com.codegym.casestudy_springboot.models.service;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    private double cost;

}
