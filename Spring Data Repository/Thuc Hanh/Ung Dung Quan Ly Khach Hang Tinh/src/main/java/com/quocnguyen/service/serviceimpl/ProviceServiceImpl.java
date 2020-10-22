package com.quocnguyen.service.serviceimpl;

import com.quocnguyen.entity.Provice;
import com.quocnguyen.repository.ProviceRepository;
import com.quocnguyen.service.ProviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviceServiceImpl implements ProviceService {
    @Autowired
    ProviceRepository proviceRepository;

    @Override
    public void save(Provice provice) {
        proviceRepository.save(provice);
    }

    @Override
    public void remove(Provice provice) {
        proviceRepository.delete(provice);
    }

    @Override
    public List<Provice> listAll() {
        return proviceRepository.findAll();
    }

    @Override
    public Provice findById(Long id) {
        return proviceRepository.findById(id).orElse(null);
    }
}
