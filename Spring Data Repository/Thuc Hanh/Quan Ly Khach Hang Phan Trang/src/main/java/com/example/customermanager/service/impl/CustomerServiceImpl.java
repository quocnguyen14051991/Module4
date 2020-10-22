package com.example.customermanager.service.impl;

import com.example.customermanager.entity.Customer;
import com.example.customermanager.repository.CustomerRepository;
import com.example.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findByNameContaining(Pageable pageable, String name) {
//        return this.customerRepository.searchCustomerByName(pageable,name);
    return this.customerRepository.seachCustomerByFirstName(pageable,name);
    }

}
