package com.quocnguyen.service;

import com.quocnguyen.entity.Customer;
import com.quocnguyen.entity.Provice;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    void remove(Customer customer);
    List<Customer> listAll();
    Customer findById(Long id);
}
