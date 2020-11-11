package com.example.keystudy.service;

import com.example.keystudy.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void delete(Customer customer);

    List<Customer> findByCustomerName(String name);

    Page<Customer> findByCusName(String name,Pageable pageable);
}
