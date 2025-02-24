package com.example.SpringbootJPAPractice.service;

import com.example.SpringbootJPAPractice.DTO.CategoryDTO;
import com.example.SpringbootJPAPractice.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryServ {
    List<Category> getAllCategories();
    void  createCategory(CategoryDTO categoryDTO);
    Optional<Category> getCategoryById(Long id);
    boolean updateCategory(Long id, Category newCategory);
    boolean deleteCategory(Long id);
}
