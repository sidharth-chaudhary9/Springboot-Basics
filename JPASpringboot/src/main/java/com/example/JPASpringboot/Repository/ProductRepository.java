package com.example.JPASpringboot.Repository;

import com.example.JPASpringboot.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
