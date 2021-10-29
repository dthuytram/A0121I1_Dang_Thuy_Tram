package com.codegym.casestudy_springboot.models.employee;


import com.codegym.casestudy_springboot.models.user.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    private LocalDate birthDay;

    @Column(length = 15)
    private String identityCard;

    private double salary;

    @Column(length = 10)
    private String phone;

    private String email;

    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL)
    private EducationDegree educationDegree;

    @ManyToOne(cascade = CascadeType.ALL)
    private Division division;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private User user;
}
