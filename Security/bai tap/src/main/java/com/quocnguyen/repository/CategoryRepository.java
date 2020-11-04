package com.quocnguyen.repository;

import com.quocnguyen.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Page<CategoryEntity> findByNameCategory(String name, Pageable pageable);
}
