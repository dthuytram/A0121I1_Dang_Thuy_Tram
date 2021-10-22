package com.codegym.casestudy_springboot.repositories;

import com.codegym.casestudy_springboot.models.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
