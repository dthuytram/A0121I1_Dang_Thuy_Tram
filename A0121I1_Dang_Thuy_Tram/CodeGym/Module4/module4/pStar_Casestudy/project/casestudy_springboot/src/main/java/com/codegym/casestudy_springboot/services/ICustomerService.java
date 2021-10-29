package com.codegym.casestudy_springboot.services;

import com.codegym.casestudy_springboot.models.customer.Customer;
import com.codegym.casestudy_springboot.models.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    List<CustomerType> getListCusType() ;
    Page<Customer> findByName(String name, Pageable pageable);
}
