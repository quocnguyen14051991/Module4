package com.quocnguyen.repository;

import com.quocnguyen.entity.BlockA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<BlockA,Integer> {
}
