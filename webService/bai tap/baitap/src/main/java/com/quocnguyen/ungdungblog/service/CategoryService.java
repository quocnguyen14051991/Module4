package com.quocnguyen.ungdungblog.service;

import com.quocnguyen.ungdungblog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    Category findById(Integer id);
    void save(Category category);
    void delete(Category category);
    Page<Category> findByNameCategory(String keyword,Pageable pageable);
}
