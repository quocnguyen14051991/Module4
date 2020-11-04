package com.quocnguyen.service;

import com.quocnguyen.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findAll();
    Page<CategoryEntity> findAll(Pageable pageable);
    CategoryEntity findById(Integer id);
    void save(CategoryEntity category);
    void delete(CategoryEntity category);
    Page<CategoryEntity> findByNameCategory(String keyword, Pageable pageable);
}
