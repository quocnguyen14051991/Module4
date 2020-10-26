package com.example.baitap.service;

import com.example.baitap.entity.Sach;

import java.util.List;

public interface SachService {
    List<Sach> findAll();
    void save(Sach sach);
    Sach  findById(Integer idSach);
    Double muonSach(Integer idSach);
    Double traSach(Double mamuon);
}
