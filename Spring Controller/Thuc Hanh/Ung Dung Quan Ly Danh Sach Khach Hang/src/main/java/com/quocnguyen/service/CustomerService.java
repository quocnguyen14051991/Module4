package com.quocnguyen.service;

import com.quocnguyen.model.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    List<Customer> showListCus=new ArrayList<>();
    List<Customer> showList();
    Customer findOne(Long id);

}
