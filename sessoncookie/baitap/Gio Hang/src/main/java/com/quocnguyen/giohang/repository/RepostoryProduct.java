package com.quocnguyen.giohang.repository;

import com.quocnguyen.giohang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepostoryProduct extends JpaRepository<Product,Integer> {
}
