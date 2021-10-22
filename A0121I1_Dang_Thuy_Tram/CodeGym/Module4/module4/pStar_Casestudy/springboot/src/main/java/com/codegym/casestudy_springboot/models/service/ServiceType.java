package com.codegym.casestudy_springboot.models.service;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;
}
