package com.quocnguyen.service;

import com.quocnguyen.entity.DigitalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DigitalService {
    Page<DigitalEntity> findAll(Pageable pageable);
    DigitalEntity findById(Integer id);
    void save(DigitalEntity digital);
    void delete(DigitalEntity digital);
}
