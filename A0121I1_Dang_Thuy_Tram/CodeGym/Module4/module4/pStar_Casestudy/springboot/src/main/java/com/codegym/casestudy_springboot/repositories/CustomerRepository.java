package com.codegym.casestudy_springboot.repositories;

import com.codegym.casestudy_springboot.models.customer.Customer;
import com.codegym.casestudy_springboot.models.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAll(Pageable pageable);
    @Query("select ct from CustomerType ct")
    List<CustomerType> findAllCustomerType();
    @Query("select c from Customer c where "
            +"concat(c.name,'')"
            +"like %?1%"
    )
    Page<Customer> findCustomerByName(String name,Pageable pageable);
    Customer findById(int id);
}
