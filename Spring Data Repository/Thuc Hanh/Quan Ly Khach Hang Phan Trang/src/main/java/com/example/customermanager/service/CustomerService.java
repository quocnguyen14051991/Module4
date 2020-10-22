package com.example.customermanager.service;

import com.example.customermanager.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer);

    Page<Customer> findByNameContaining(Pageable pageable, String name);
}
