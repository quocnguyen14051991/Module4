package com.quocnguyen.service;

import com.quocnguyen.entity.Provice;

import java.util.List;

public interface ProviceService {
void save(Provice provice);
void remove(Provice provice);
List<Provice> listAll();
Provice findById(Long id);
}

