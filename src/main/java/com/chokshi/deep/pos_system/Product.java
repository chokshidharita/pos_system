package com.chokshi.deep.pos_system;

public class Product {
    int quantity;
    String product;
    int price;

    public Product() {
    }

    public Product(int quantity, String product, int price) {
        this.quantity = quantity;
        this.product = product;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
