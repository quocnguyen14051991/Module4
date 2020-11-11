package com.example.keystudy.service.impl;

import com.example.keystudy.entity.customer.CustomerType;
import com.example.keystudy.repository.TypeCustomerRepository;
import com.example.keystudy.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements TypeCustomerService {
    @Autowired
    TypeCustomerRepository typeCustomerRepository;
    @Override
    public List<CustomerType> findAll() {
        return this.typeCustomerRepository.findAll();
    }
}
