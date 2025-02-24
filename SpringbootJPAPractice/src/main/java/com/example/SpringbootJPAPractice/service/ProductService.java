package com.example.SpringbootJPAPractice.service;

import com.example.SpringbootJPAPractice.DTO.ProductDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.entity.Product;
import com.example.SpringbootJPAPractice.repository.CategoryRepository;
import com.example.SpringbootJPAPractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServ{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public boolean createAProduct(ProductDTO product1) {
        Optional<Category> c1=categoryRepository.findById(product1.getCategoryId());
        if(c1.isEmpty()){
            return false;
        }
        Product p1=new Product();
        p1.setName(product1.getName());
        p1.setStock(product1.getStock());
        p1.setDescription(product1.getDescription());
        p1.setCategory(c1.get());
        productRepository.save(p1);
        return true;
    }

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public boolean deleteById(Long id){
        Optional<Product> p1=productRepository.findById(id);
        if(p1.isEmpty()){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public boolean updateById(ProductDTO product,Long id){
        if(productRepository.findById(id).isEmpty()){
            return false;
        }
        Product p1=productRepository.findById(id).orElse(null);
        Optional<Category> c1=categoryRepository.findById(product.getCategoryId());
        p1.setCategory(c1.get());
        p1.setName(product.getName());
        p1.setStock(product.getStock());
        p1.setDescription(product.getDescription());
        productRepository.save(p1);
        return true;
    }

}
