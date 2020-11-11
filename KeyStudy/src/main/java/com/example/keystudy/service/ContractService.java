package com.example.keystudy.service;

import com.example.keystudy.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    List<Contract> findAll();
    Contract findById(Integer id);
    void save(Contract contract);
    void delete(Contract contract);
}
