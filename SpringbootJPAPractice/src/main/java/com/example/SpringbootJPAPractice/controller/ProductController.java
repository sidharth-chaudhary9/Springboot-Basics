package com.example.SpringbootJPAPractice.controller;

import com.example.SpringbootJPAPractice.DTO.ProductDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.entity.Product;
import com.example.SpringbootJPAPractice.repository.CategoryRepository;
import com.example.SpringbootJPAPractice.repository.ProductRepository;
import com.example.SpringbootJPAPractice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO){
        if(productService.createAProduct(productDTO)==true){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> p1=productService.getById(id);
        if(p1.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p1.get());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
        boolean p1= productService.deleteById(id);
        if(p1==true){
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO product,@PathVariable Long id){
        if(productService.updateById(product,id)==true){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
