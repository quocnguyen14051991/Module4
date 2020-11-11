package com.example.keystudy.repository;

import com.example.keystudy.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCustomerRepository extends JpaRepository<CustomerType,Integer> {
}
