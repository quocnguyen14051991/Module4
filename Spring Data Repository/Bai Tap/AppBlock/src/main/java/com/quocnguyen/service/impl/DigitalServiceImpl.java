package com.quocnguyen.service.impl;

import com.quocnguyen.entity.Digital;
import com.quocnguyen.repository.DigitalRepository;
import com.quocnguyen.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DigitalServiceImpl implements DigitalService {
    @Autowired
    DigitalRepository digitalRepository;

    @Override
    public Page<Digital> findAll(Pageable pageable) {
        return digitalRepository.findAll(pageable);
    }

    @Override
    public Digital findById(Integer id) {
        return digitalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Digital digital) {
        digitalRepository.save(digital);
    }

    @Override
    public void delete(Digital digital) {
        digitalRepository.delete(digital);
    }
}
