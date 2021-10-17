package com.codegym.practice_customer_aop.services.impl;

import com.codegym.practice_customer_aop.models.Customer;
import com.codegym.practice_customer_aop.repositories.CustomerRepository;
import com.codegym.practice_customer_aop.services.CustomerService;
import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(int id) throws Exception {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new Exception("Customer not found!");
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }


}
