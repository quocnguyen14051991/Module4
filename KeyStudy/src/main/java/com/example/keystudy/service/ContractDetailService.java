package com.example.keystudy.service;

import com.example.keystudy.entity.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail findById(Integer id);

    void save(ContractDetail contractDetail);

    void delete(ContractDetail contractDetail);
}
