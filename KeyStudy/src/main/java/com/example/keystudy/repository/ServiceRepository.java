package com.example.keystudy.repository;

import com.example.keystudy.entity.service.ServiceFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceFurama,String> {

}
