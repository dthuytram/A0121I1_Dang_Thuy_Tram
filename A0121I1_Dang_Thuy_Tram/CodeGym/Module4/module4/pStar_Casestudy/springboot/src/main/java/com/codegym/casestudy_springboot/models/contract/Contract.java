package com.codegym.casestudy_springboot.models.contract;

import com.codegym.casestudy_springboot.models.customer.Customer;
import com.codegym.casestudy_springboot.models.employee.Employee;
import com.codegym.casestudy_springboot.models.service.Service;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private  double deposit;

    private double total;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Service service;

}
