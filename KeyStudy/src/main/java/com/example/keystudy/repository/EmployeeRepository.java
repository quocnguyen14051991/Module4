package com.example.keystudy.repository;

import com.example.keystudy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value="select * from employee where employee_name like concat('%',?1,'%')", nativeQuery=true)
    Page<Employee> findByName(String name, Pageable pageable);
}
