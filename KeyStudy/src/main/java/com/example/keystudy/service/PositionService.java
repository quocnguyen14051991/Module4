package com.example.keystudy.service;

import com.example.keystudy.entity.employee.PositionEmployee;

import java.util.List;

public interface PositionService {
    List<PositionEmployee> findAll();
}
