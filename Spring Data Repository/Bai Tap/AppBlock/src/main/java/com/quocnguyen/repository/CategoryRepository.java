package com.quocnguyen.repository;

import com.quocnguyen.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findByNameCategory(String name, Pageable pageable);
}
