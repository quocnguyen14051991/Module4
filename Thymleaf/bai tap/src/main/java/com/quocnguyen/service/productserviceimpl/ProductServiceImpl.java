package com.quocnguyen.service.productserviceimpl;

import com.quocnguyen.model.Product;
import com.quocnguyen.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    public static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Omo", 200, 20));
        productMap.put(2, new Product(2, "OLala", 200, 20));
        productMap.put(3, new Product(3, "Saziki", 200, 20));
        productMap.put(4, new Product(4, "Omaja", 200, 20));
    }

    @Override
    public List<Product> listAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getIdProduct(), product);
    }

    @Override
    public void delete(int idProduct) {
        productMap.remove(idProduct);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public Product findId(int id) {
        return productMap.get(id);
    }
}
