package com.quocnguyen.giohang.service.impl;

import com.quocnguyen.giohang.entity.Product;
import com.quocnguyen.giohang.repository.RepostoryProduct;
import com.quocnguyen.giohang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    RepostoryProduct repostoryProduct;
    @Override
    public List<Product> findAll() {
        return repostoryProduct.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return this.repostoryProduct.findById(id).orElse(null);
    }
}
