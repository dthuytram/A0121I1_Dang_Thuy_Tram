package com.codegym.smartphone.service.impl;

import com.codegym.smartphone.model.SmartPhone;
import com.codegym.smartphone.repository.SmartPhoneRepository;
import com.codegym.smartphone.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SmartPhoneServiceImpl implements SmartPhoneService {

    @Autowired
    SmartPhoneRepository smartPhoneRepository;


    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone phone) {
        return smartPhoneRepository.save(phone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartPhone = smartPhoneRepository.findById(id).orElse(null);
        smartPhoneRepository.deleteById(id);
        return smartPhone;
    }
}
