package com.codegym.practice_customer_aop.services.impl;

import com.codegym.practice_customer_aop.models.Province;
import com.codegym.practice_customer_aop.repositories.ProvinceRepository;
import com.codegym.practice_customer_aop.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }


    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(int id) {
        provinceRepository.deleteById(id);
    }
}
