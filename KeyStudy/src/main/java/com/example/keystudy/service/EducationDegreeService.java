package com.example.keystudy.service;

import com.example.keystudy.entity.employee.EducationDegree;
import com.example.keystudy.repository.EducationDegreeRepository;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
}
