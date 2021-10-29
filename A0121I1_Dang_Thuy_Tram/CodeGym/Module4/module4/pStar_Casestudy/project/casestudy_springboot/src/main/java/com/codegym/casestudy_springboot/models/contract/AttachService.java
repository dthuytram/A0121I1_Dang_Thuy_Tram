package com.codegym.casestudy_springboot.models.contract;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    private double cost;

    @Column(length = 45)
    private String unit;

    @Column(length = 45)
    private String status;

}
