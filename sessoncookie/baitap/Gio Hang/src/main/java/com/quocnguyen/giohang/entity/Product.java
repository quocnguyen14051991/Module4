package com.quocnguyen.giohang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {
    @Id
    @Column(name = "id_product")
    private Integer id;
    private String nameProduct;
    private Double priceOldProduct;
    private Double priceNewProduct;
    private String imageProduct;
    private String desProduct;

    public Product() {
    }

    public Product(Integer id, String nameProduct, Double priceOldProduct, Double priceNewProduct, String imageProduct ,String desProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceOldProduct = priceOldProduct;
        this.priceNewProduct = priceNewProduct;
        this.imageProduct = imageProduct;
        this.desProduct=desProduct;
    }

    public String getDesProduct() {
        return desProduct;
    }

    public void setDesProduct(String desProduct) {
        this.desProduct = desProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceOldProduct() {
        return priceOldProduct;
    }

    public void setPriceOldProduct(Double priceOldProduct) {
        this.priceOldProduct = priceOldProduct;
    }

    public Double getPriceNewProduct() {
        return priceNewProduct;
    }

    public void setPriceNewProduct(Double priceNewProduct) {
        this.priceNewProduct = priceNewProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}
