package com.codegym.casestudy_springboot.models.employee;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;
}
