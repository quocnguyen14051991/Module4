package com.quocnguyen.service;

import com.quocnguyen.entity.BlockA;
import jdk.nashorn.internal.ir.Block;

import java.util.List;

public interface BlockService  {
    List<BlockA> findAll();

    BlockA findById(Integer id);

    void save(BlockA blockA);

    void remove(BlockA blockA);
}
