package com.quocnguyen.service;

import com.quocnguyen.entity.Category;
import com.quocnguyen.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    Category findById(Integer id);
    void save(Category category);
    void delete(Category category);
    Page<Category> findByNameCategory(String keyword,Pageable pageable);
}
