package com.example.keystudy.service;

import com.example.keystudy.entity.customer.Customer;
import com.example.keystudy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByName(String name,Pageable pageable);
    Employee findById(Integer id);
    void save(Employee employee);
    void delete(Employee employee);
}
