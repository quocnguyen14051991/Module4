package com.quocnguyen.service;

import com.quocnguyen.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);
    void edit(Customer customer);
    void delete(Customer customer);
}
