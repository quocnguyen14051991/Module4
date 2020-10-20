package com.quocnguyen.service.impl;

import com.quocnguyen.entity.Customer;
import com.quocnguyen.repository.CustomerRepository;
import com.quocnguyen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {

        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
customerRepository.edit(customer);
    }

    @Override
    public void delete(Customer customera) {
customerRepository.delete(customera);
    }
}
