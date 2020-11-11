package com.example.keystudy.repository;

import com.example.keystudy.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    List<Customer> findByCustomerName(String name);
    @Query(value="select * from Customer  where customer_name like concat('%',?1,'%')", nativeQuery = true)
    Page<Customer> findByCusName(String name, Pageable pageable);

//    // Đây là Native SQL
//    @Query(value = "select * from User u where u.email_address = ?1", nativeQuery = true)
//    User myCustomQuery2(String emailAddress);
}
