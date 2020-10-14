package com.quocnguyen.service.cusimpl;

import com.quocnguyen.model.Customer;
import com.quocnguyen.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerImpl implements CustomerService {
    static List<Customer> list = new ArrayList<>();

    static {
        list.add(new Customer(1, "Quang", "2000-02-02"));
        list.add(new Customer(2, "Long", "2000-02-02"));
        list.add(new Customer(3, "Hieu", "2000-02-02"));
        list.add(new Customer(4, "Phuong", "2000-02-02"));
    }

    @Override
    public List<Customer> showList() {
        return list;
    }

    @Override
    public Customer findOne(Long id) {
        long temp = Long.parseLong(String.valueOf(id));
        for (Customer cus : list) {
            if (temp == (cus.getIdCustomer())) {
                return cus;
            }
        }
        return null;
    }
}
