package com.quocnguyen.ungdungblog.service.impl;

import com.quocnguyen.ungdungblog.entity.Digital;
import com.quocnguyen.ungdungblog.repository.DigitalRepository;
import com.quocnguyen.ungdungblog.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitalServiceImpl implements DigitalService {
    @Autowired
    DigitalRepository digitalRepository;
    @Override
    public Page<Digital> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Digital> findAll() {
        return digitalRepository.findAll();
    }

    @Override
    public Digital findById(Integer id) {

        return digitalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Digital digital) {

    }

    @Override
    public void delete(Digital digital) {

    }

    @Override
    public List<Digital> findById_Category(Integer id) {
        return digitalRepository.searchByIdCategory(id);
    }

}
