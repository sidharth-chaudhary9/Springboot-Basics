package com.example.SpringbootJPAPractice.DTO;

import com.example.SpringbootJPAPractice.entity.Product;

import java.util.List;

public class CategoryDTO {
    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
