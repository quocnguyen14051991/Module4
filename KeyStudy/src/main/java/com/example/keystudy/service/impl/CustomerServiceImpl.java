package com.example.keystudy.service.impl;

import com.example.keystudy.entity.customer.Customer;
import com.example.keystudy.repository.CustomerRepository;
import com.example.keystudy.service.CustomerService;
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
    public Customer findById(String id) {

        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public List<Customer> findByCustomerName(String name) {
        return this.customerRepository.findByCustomerName(name);
    }



    @Override
    public Page<Customer> findByCusName(String name,Pageable pageable) {
        return this.customerRepository.findByCusName(name,pageable);
    }
}
