package com.quocnguyen.service.impl;

import com.quocnguyen.entity.CategoryEntity;
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
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<CategoryEntity> findAll(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public CategoryEntity findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(CategoryEntity category) {
        categoryRepository.delete(category);
    }

    @Override
    public Page<CategoryEntity> findByNameCategory(String keyword, Pageable pageable) {
        if(keyword != null){
            return categoryRepository.findByNameCategory(keyword,pageable);
        }
        return this.categoryRepository.findAll(pageable);
    }
}
