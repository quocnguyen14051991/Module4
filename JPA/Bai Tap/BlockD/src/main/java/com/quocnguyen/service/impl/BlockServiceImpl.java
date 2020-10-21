package com.quocnguyen.service.impl;

import com.quocnguyen.entity.BlockA;
import com.quocnguyen.repository.BlockRepository;
import com.quocnguyen.service.BlockService;
import jdk.nashorn.internal.ir.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    BlockRepository blockRepository;

    @Override
    public List<BlockA> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public BlockA findById(Integer id) {

        return blockRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BlockA blockA) {
        blockRepository.save(blockA);
    }

    @Override
    public void remove(BlockA blockA) {
        blockRepository.delete(blockA);
    }
}
