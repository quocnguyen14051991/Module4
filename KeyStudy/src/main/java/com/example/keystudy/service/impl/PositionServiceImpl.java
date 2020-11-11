package com.example.keystudy.service.impl;

import com.example.keystudy.entity.employee.PositionEmployee;
import com.example.keystudy.repository.PositionRepository;
import com.example.keystudy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public List<PositionEmployee> findAll() {
       return  this.positionRepository.findAll();

    }
}
