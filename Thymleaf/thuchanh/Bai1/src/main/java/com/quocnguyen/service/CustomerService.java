package com.quocnguyen.service;

import com.quocnguyen.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void update(int id,Customer customer);
    void delete(int id);
    Customer findId(int id);
}
