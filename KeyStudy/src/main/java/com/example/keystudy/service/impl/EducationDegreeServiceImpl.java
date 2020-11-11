package com.example.keystudy.service.impl;

import com.example.keystudy.entity.employee.EducationDegree;
import com.example.keystudy.repository.EducationDegreeRepository;
import com.example.keystudy.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return this.educationDegreeRepository.findAll();
    }
}
