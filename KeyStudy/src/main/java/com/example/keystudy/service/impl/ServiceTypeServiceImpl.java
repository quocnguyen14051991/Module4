package com.example.keystudy.service.impl;

import com.example.keystudy.entity.service.ServiceType;
import com.example.keystudy.repository.ServiceTypeRepository;
import com.example.keystudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeRepository.findAll();
    }
}
