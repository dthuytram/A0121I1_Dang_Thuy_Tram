package com.codegym.casestudy_springboot.models.employee;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;
}
