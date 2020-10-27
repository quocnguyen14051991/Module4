package com.quocnguyen.giohang.model;

import com.quocnguyen.giohang.entity.Product;

public class CardItem {
    private final Product product;
    private int quantity;
    private double subTotal; // tong tien cho 1 item

    public CardItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.subTotal = product.getPriceNewProduct();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        subTotal = product.getPriceNewProduct() * quantity;
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
