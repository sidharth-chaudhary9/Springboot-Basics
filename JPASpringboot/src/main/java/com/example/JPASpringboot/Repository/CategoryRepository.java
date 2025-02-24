package com.example.JPASpringboot.Repository;

import com.example.JPASpringboot.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
