package com.quocnguyen.restfull.repository;

import com.quocnguyen.restfull.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
