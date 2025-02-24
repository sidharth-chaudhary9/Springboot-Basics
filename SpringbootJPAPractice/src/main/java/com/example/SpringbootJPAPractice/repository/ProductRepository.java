package com.example.SpringbootJPAPractice.repository;

import com.example.SpringbootJPAPractice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
