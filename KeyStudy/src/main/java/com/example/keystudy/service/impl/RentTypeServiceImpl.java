package com.example.keystudy.service.impl;

import com.example.keystudy.entity.service.RentType;
import com.example.keystudy.repository.RentTypeRepository;
import com.example.keystudy.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
