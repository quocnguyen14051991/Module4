package com.example.keystudy.service.impl;

import com.example.keystudy.entity.contract.Contract;
import com.example.keystudy.repository.ContractRepository;
import com.example.keystudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return this.contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        this.contractRepository.delete(contract);
    }
}
