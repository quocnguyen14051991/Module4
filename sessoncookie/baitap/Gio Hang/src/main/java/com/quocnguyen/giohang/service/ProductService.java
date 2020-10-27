package com.quocnguyen.giohang.service;

import com.quocnguyen.giohang.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
