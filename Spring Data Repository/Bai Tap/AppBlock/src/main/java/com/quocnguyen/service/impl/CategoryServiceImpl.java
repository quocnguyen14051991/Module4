package com.quocnguyen.service.impl;

import com.quocnguyen.entity.Category;
import com.quocnguyen.repository.CategoryRepository;
import com.quocnguyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Page<Category> findByNameCategory(String keyword, Pageable pageable) {
        if(keyword != null){
            return categoryRepository.findByNameCategory(keyword,pageable);
        }
        return this.categoryRepository.findAll(pageable);
    }
}
