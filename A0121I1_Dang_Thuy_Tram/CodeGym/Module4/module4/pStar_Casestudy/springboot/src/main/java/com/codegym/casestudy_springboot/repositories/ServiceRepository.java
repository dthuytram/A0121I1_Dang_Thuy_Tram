package com.codegym.casestudy_springboot.repositories;

import com.codegym.casestudy_springboot.models.service.RentType;
import com.codegym.casestudy_springboot.models.service.Service;
import com.codegym.casestudy_springboot.models.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    Page<Service> findAll(Pageable pageable);
    @Query("select ct from ServiceType ct")
    List<ServiceType> findAllServiceType();
    @Query("select ct from RentType ct")
    List<RentType> findAllRentType();
    Service findById(String id);
}
