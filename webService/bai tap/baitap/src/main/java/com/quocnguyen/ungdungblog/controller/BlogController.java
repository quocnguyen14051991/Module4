package com.quocnguyen.ungdungblog.controller;

import com.quocnguyen.ungdungblog.entity.Category;
import com.quocnguyen.ungdungblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = this.categoryService.findAll();
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }
}
