package com.quocnguyen.restfull.service;

import com.quocnguyen.restfull.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void  remove(Customer customer);
}
