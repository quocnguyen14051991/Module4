package com.quocnguyen.service.serviceimpl;

import com.quocnguyen.entity.Customer;
import com.quocnguyen.repository.CustomerRepository;
import com.quocnguyen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> listAll() {

        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {

        customerRepository.delete(customer);
    }


    @Override
    public Customer findById(Long id) {

        return customerRepository.findById(id).orElse(null);
    }
}
