package com.example.SpringbootJPAPractice.controller;

import com.example.SpringbootJPAPractice.DTO.CategoryDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());
        when(categoryService.getAllCategories()).thenReturn(categories);

        List<Category> result = categoryController.getAllCategories();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    public void createCategory() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Test");
        categoryDTO.setProducts(new ArrayList<>());
        doNothing().when(categoryService).createCategory(any(CategoryDTO.class));

        categoryController.createCategory(categoryDTO);
        verify(categoryService, times(1)).createCategory(categoryDTO);
    }

    @Test
    public void getCategoryByIdFound() {
        Category category = new Category();
        category.setName("Test Category");
        when(categoryService.getCategoryById(1L)).thenReturn(Optional.of(category));

        ResponseEntity<Category> response = categoryController.getCategoryById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(category, response.getBody());
    }

    @Test
    public void getCategoryByIdNotFound() {
        when(categoryService.getCategoryById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Category> response = categoryController.getCategoryById(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void updateCategoryFound() {
        Category updatedCategory = new Category();
        updatedCategory.setName("Updated Name");
        when(categoryService.updateCategory(eq(1L), any(Category.class))).thenReturn(true);

        ResponseEntity<Category> response = categoryController.updateCategory(1L, updatedCategory);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void updateCategoryNotFound() {
        Category updatedCategory = new Category();
        when(categoryService.updateCategory(eq(1L), any(Category.class))).thenReturn(false);

        ResponseEntity<Category> response = categoryController.updateCategory(1L, updatedCategory);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void deleteCategory() {
        when(categoryService.deleteCategory(1L)).thenReturn(true);

        ResponseEntity<Category> response = categoryController.deleteCategory(1L);
        assertEquals(200, response.getStatusCodeValue());
        verify(categoryService, times(1)).deleteCategory(1L);
    }
}

