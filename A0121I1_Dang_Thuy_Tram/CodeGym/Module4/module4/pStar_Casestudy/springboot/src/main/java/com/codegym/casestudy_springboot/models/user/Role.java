package com.codegym.casestudy_springboot.models.user;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;



}
