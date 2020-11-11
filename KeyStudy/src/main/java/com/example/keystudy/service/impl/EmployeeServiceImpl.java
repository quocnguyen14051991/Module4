package com.example.keystudy.service.impl;

import com.example.keystudy.entity.employee.Employee;
import com.example.keystudy.repository.EmployeeRepository;
import com.example.keystudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return this.employeeRepository.findByName(name,pageable);
    }


    @Override
    public Employee findById(Integer id) {

        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.employeeRepository.delete(employee);
    }
}
