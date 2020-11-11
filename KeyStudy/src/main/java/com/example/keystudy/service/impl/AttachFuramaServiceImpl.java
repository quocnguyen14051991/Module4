package com.example.keystudy.service.impl;

import com.example.keystudy.entity.contract.AttachService;
import com.example.keystudy.repository.AttachServiceRepository;
import com.example.keystudy.service.AttachFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFuramaServiceImpl implements AttachFuramaService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return this.attachServiceRepository.findAll();
    }
}
