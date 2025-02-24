package com.example.SpringbootJPAPractice.service;

import com.example.SpringbootJPAPractice.DTO.ProductDTO;
import com.example.SpringbootJPAPractice.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServ {
     List<Product> getAllProducts();
     boolean createAProduct(ProductDTO product1);
     Optional<Product> getById(Long id);
     boolean deleteById(Long id);
     boolean updateById(ProductDTO product,Long id);
}
