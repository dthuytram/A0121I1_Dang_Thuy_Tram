package com.codegym.practice_customer_aop.services;

import com.codegym.practice_customer_aop.models.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService {
    Page<Province> findAll(Pageable pageable);
    Province findById(int id);

    void save(Province province);

    void remove(int id);
}
