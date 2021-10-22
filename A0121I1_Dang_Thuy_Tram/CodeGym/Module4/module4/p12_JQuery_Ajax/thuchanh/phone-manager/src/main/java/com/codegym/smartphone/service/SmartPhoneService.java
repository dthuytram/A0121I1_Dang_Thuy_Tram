package com.codegym.smartphone.service;

import com.codegym.smartphone.model.SmartPhone;

import java.util.List;

public interface SmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
