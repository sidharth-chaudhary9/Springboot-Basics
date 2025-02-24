package com.example.JPASpringboot.Controller;

import com.example.JPASpringboot.Entity.Category;
import com.example.JPASpringboot.Entity.Product;
import com.example.JPASpringboot.Repository.CategoryRepository;
import com.example.JPASpringboot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Create a new Product (with Category association)
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Ensure the category exists if provided
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
            if (!category.isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            product.setCategory(category.get());
        }
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Get all Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestBody Product productDetails) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Product product = productOptional.get();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        // Update Category if provided
        if (productDetails.getCategory() != null && productDetails.getCategory().getId() != null) {
            Optional<Category> category = categoryRepository.findById(productDetails.getCategory().getId());
            category.ifPresent(product::setCategory);
        }

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a Product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
