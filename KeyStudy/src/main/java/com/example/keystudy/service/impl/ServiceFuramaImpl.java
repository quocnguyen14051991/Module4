package com.example.keystudy.service.impl;

import com.example.keystudy.entity.service.ServiceFurama;
import com.example.keystudy.repository.ServiceRepository;
import com.example.keystudy.service.ServiceFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFuramaImpl implements ServiceFuramaService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<ServiceFurama> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<ServiceFurama> findAll() {
        return this.serviceRepository.findAll();
    }

    @Override
    public void save(ServiceFurama service) {
        this.serviceRepository.save(service);
    }
}
