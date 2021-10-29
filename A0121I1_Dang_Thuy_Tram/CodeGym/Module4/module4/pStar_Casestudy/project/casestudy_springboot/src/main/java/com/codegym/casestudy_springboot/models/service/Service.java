package com.codegym.casestudy_springboot.models.service;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    private int area;

    private double cost;

    private int maxPeople;

    @ManyToOne(cascade = CascadeType.ALL)
    private RentType rentType;

    @ManyToOne(cascade = CascadeType.ALL)
    private ServiceType serviceType;

    @Column(length = 45)
    private String standardRoom;

    @Column(length = 45)
    private String descriptionOtherConvenience;

    private double poolArea;

    private int floor;
}

