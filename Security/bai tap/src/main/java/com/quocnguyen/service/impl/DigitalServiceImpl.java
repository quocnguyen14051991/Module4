package com.quocnguyen.service.impl;

import com.quocnguyen.entity.DigitalEntity;
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
    public Page<DigitalEntity> findAll(Pageable pageable) {
        return digitalRepository.findAll(pageable);
    }

    @Override
    public DigitalEntity findById(Integer id) {
        return digitalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DigitalEntity digital) {
        digitalRepository.save(digital);
    }

    @Override
    public void delete(DigitalEntity digital) {
        digitalRepository.delete(digital);
    }
}
