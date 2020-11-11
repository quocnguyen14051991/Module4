package com.example.keystudy.service.impl;

import com.example.keystudy.entity.employee.Division;
import com.example.keystudy.repository.DivisionRepository;
import com.example.keystudy.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
