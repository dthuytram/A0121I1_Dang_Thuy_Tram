package com.codegym.smartphone.repository;

import com.codegym.smartphone.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Integer> {
}
