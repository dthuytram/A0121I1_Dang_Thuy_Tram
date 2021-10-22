package com.codegym.casestudy_springboot.models.employee;

import lombok.*;

import javax.persistence.*;

@Data
@Entity

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;
}
