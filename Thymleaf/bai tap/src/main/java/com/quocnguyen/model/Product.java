package com.quocnguyen.model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int inventoryNumber;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double price, int inventoryNumber) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.inventoryNumber = inventoryNumber;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
}
