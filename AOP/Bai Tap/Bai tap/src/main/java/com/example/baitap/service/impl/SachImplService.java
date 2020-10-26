package com.example.baitap.service.impl;

import com.example.baitap.entity.Sach;
import com.example.baitap.repository.SachRepository;
import com.example.baitap.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SachImplService implements SachService {
    @Autowired
    SachRepository sachRepository;

    @Override
    public List<Sach> findAll() {
        return this.sachRepository.findAll();
    }

    @Override
    public void save(Sach sach) {
        this.sachRepository.save(sach);

    }

    @Override
    public Sach findById(Integer idSach) {
        return this.sachRepository.findById(idSach).orElse(null);
    }

    @Override
    public Double muonSach(Integer idSach) {
        Sach sach=this.sachRepository.findById(idSach).orElse(null);
        this.sachRepository.delete(sach);
        Double maMuon=Math.floor(Math.random()*100000+1);
        return maMuon;
    }

    @Override
    public Double traSach(Double mamuon) {
        return null;
    }
}
