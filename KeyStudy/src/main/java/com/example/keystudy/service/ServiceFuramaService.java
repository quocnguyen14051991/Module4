package com.example.keystudy.service;

import com.example.keystudy.entity.service.ServiceFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceFuramaService {
    Page<ServiceFurama> findAll(Pageable pageable);

    List<ServiceFurama> findAll();

    void save(ServiceFurama service);

}
