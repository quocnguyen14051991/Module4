package com.example.keystudy.service.impl;

import com.example.keystudy.entity.contract.ContractDetail;
import com.example.keystudy.repository.ContractDetailRepository;
import com.example.keystudy.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(ContractDetail contractDetail) {

    }
}
