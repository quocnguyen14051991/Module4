package com.quocnguyen.service;

import com.quocnguyen.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAll();

    void save(Product product);

    void delete(int idProduct);

    void update(int id, Product product);

    Product findId(int id);
}
