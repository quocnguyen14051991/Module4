package com.quocnguyen.service;

import com.quocnguyen.entity.Category;
import com.quocnguyen.entity.Digital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DigitalService {
    Page<Digital> findAll(Pageable pageable);
    Digital findById(Integer id);
    void save(Digital digital);
    void delete(Digital digital);
}
