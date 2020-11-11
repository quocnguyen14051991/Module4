package com.example.keystudy.repository;

import com.example.keystudy.entity.employee.PositionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEmployee, Integer> {
}
