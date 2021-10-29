package com.codegym.casestudy_springboot.services.impl;

import com.codegym.casestudy_springboot.models.customer.Customer;
import com.codegym.casestudy_springboot.models.customer.CustomerType;
import com.codegym.casestudy_springboot.repositories.ContractRepository;
import com.codegym.casestudy_springboot.repositories.CustomerRepository;
import com.codegym.casestudy_springboot.repositories.CustomerTypeRepository;
import com.codegym.casestudy_springboot.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository ;
    @Autowired
    CustomerTypeRepository customerTypeRepository ;

    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<CustomerType> getListCusType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return name.equals("") ? customerRepository.findAll(pageable) : customerRepository.findCustomerByName(name,pageable);
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteAllByCustomer_Id(id);
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
