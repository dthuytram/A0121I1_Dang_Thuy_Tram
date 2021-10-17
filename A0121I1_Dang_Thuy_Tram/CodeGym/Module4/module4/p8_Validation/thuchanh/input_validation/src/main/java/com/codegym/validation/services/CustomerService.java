package com.codegym.validation.services;

import com.codegym.validation.models.Customer;

import java.util.List;

public interface CustomerService  {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}
