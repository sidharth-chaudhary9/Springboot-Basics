package com.example.SpringbootJPAPractice.service;

import com.example.SpringbootJPAPractice.DTO.CategoryDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.entity.Product;
import com.example.SpringbootJPAPractice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {
    @InjectMocks
    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createCategory(){
        CategoryDTO c1 = new CategoryDTO();
        c1.setName("Electronic");
        List<Product> productList=new ArrayList<>();
        Product p1= new Product();
        p1.setStock(10);
        p1.setName("Iphone");
        p1.setDescription("New");
        productList.add(p1);
        c1.setProducts(productList);
        Category c2=new Category();
        c2.setName(c1.getName());
        c2.setCategoryId(1L);
        c2.setProducts(productList);

        when(categoryRepository.save(c2)).thenReturn(c2);

        categoryService.createCategory(c1);
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    public void getCategories(){
        List<Category> categoryList=new ArrayList<>();
        Category c1= new Category();
        c1.setCategoryId(1L);
        c1.setName("Fur");
        categoryList.add(c1);

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<Category> c2=categoryService.getAllCategories();

        assertNotNull(c2);
        assertEquals(1,c2.size());
        assertEquals(1L,c2.get(0).getCategoryId());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void getCategoryById(){
        Category c1= new Category();
        c1.setCategoryId(1L);
        c1.setName("Hello");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(c1));

        Optional<Category> c2= categoryService.getCategoryById(1L);
        assertTrue(c2.isPresent());
        assertEquals(1L,c2.get().getCategoryId());

        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    public void updateCategoryFound(){
        Category old= new Category();
        old.setName("Hi");
        old.setCategoryId(1L);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(old));
        Category newone= new Category();
        newone.setName("New Hi");
        when(categoryRepository.save(any(Category.class))).thenReturn(newone);

        boolean res= categoryService.updateCategory(1L,newone);
        assertTrue(res);
        assertEquals("New Hi",old.getName());
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    public void updateCategoryNotFound(){
        Category c1= new Category();
        c1.setName("HI");
        c1.setCategoryId(1L);

        when(categoryRepository.findById(2L)).thenReturn(Optional.empty());

        boolean res= categoryService.updateCategory(2L,c1);
        assertFalse(res);
        verify(categoryRepository, times(1)).findById(2L);
    }

    @Test
    public void deleteCategoryFound(){
        Category c1=new Category();
        c1.setName("Helll");
        c1.setCategoryId(1L);

        when(categoryRepository.existsById(1L)).thenReturn(true);
        doNothing().when(categoryRepository).deleteById(1L);

        boolean res= categoryService.deleteCategory(1L);
        assertTrue(res);
        verify(categoryRepository, times(1)).deleteById(1L);
    }

    @Test
    public void deleteCategoryNotFound(){
        Category c1=new Category();
        c1.setName("Helll");
        c1.setCategoryId(1L);

        when(categoryRepository.existsById(2L)).thenReturn(false);

        boolean res = categoryService.deleteCategory(1L);

        assertFalse(res);
        verify(categoryRepository, times(1)).existsById(1L);
    }


}
