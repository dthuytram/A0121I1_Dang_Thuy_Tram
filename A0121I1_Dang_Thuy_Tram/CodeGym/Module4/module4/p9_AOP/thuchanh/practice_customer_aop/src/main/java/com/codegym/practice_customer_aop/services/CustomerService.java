package com.codegym.practice_customer_aop.services;

import com.codegym.practice_customer_aop.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService  {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(int id) throws Exception;

    void save(Customer customer);

    void remove(int id);

}
