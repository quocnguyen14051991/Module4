package com.quocnguyen.repository;

import com.quocnguyen.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);
    void edit(Customer customer);
    void delete(Customer customer);
}
