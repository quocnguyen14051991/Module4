package com.quocnguyen.service.CustomerServiceImpl;

import com.quocnguyen.model.Customer;
import com.quocnguyen.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerServiceImpl implements CustomerService {
    public static Map<Integer  ,Customer > customerMap=new HashMap<>();
    static {
        customerMap.put(1,new Customer(1,"Quoc nguyen ","Quocnguyen@gmail.com","Da Nang"));
        customerMap.put(2,new Customer(2,"Doan nguyen ","longnguyen@gmail.com","Da Nang"));
        customerMap.put(3,new Customer(3,"Phuong nguyen ","danghieu@gmail.com","Da Nang"));
        customerMap.put(4,new Customer(4,"Long nguyen ","phongphong@gmail.com","Da Nang"));
    }
    @Override
    public List<Customer> findAll() {
        List<Customer> customersList=new ArrayList<>(customerMap.values());
        return customersList;
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);

    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void delete(int id) {
        customerMap.remove(id);

    }

    @Override
    public Customer findId(int id) {
        return customerMap.get(id);
    }

    public static void main(String[] args) {
        System.out.println("kk");
    }
}
