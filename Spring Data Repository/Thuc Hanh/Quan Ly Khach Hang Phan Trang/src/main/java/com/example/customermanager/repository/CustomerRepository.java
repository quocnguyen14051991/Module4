package com.example.customermanager.repository;

import com.example.customermanager.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findAllByLastNameContaining(Pageable pageable,String name);
    @Query(value = "select * from customer where last_name like concat('%', ?1, '%')", nativeQuery = true)
    Page<Customer> searchCustomerByName(Pageable pageable,String name);
    @Query(value="select * from customer  where  first_Name like concat('%',?1,'%') ",nativeQuery=true)
    Page<Customer> seachCustomerByFirstName(Pageable pageable,String name);
}
