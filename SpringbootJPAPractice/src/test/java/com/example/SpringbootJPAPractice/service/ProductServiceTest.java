package com.example.SpringbootJPAPractice.service;

import com.example.SpringbootJPAPractice.DTO.ProductDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.entity.Product;
import com.example.SpringbootJPAPractice.repository.CategoryRepository;
import com.example.SpringbootJPAPractice.repository.ProductRepository;
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

public class ProductServiceTest {
    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createProduct() {
        ProductDTO p1 = new ProductDTO();
        p1.setName("Laptop");
        p1.setDescription("Gaming Laptop");
        p1.setStock(5);
        p1.setCategoryId(1L);

        Category category = new Category();
        category.setCategoryId(1L);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        boolean result = productService.createAProduct(p1);

        assertTrue(result);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void getProducts() {
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product();
        p1.setProductId(1L);
        p1.setName("Tablet");
        productList.add(p1);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> p2 = productService.getAllProducts();

        assertNotNull(p2);
        assertEquals(1, p2.size());
        assertEquals(1L, p2.get(0).getProductId());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void getProductById() {
        Product p1 = new Product();
        p1.setProductId(1L);
        p1.setName("Smartphone");

        when(productRepository.findById(1L)).thenReturn(Optional.of(p1));

        Optional<Product> p2 = productService.getById(1L);
        assertTrue(p2.isPresent());
        assertEquals(1L, p2.get().getProductId());

        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    public void updateProductFound() {
        ProductDTO p1 = new ProductDTO();
        p1.setName("Updated Laptop");
        p1.setStock(10);
        p1.setDescription("Updated Description");
        p1.setCategoryId(1L);

        Product existingProduct = new Product();
        existingProduct.setProductId(1L);

        Category category = new Category();
        category.setCategoryId(1L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        boolean res = productService.updateById(p1, 1L);
        assertTrue(res);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void updateProductNotFound() {
        ProductDTO p1 = new ProductDTO();
        p1.setName("Updated Product");
        p1.setStock(10);
        p1.setDescription("Updated Description");
        p1.setCategoryId(1L);

        when(productRepository.findById(2L)).thenReturn(Optional.empty());

        boolean res = productService.updateById(p1, 2L);
        assertFalse(res);
        verify(productRepository, times(1)).findById(2L);
    }

    @Test
    public void deleteProductFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(new Product()));
        doNothing().when(productRepository).deleteById(1L);

        boolean res = productService.deleteById(1L);
        assertTrue(res);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    public void deleteProductNotFound() {
        when(productRepository.findById(2L)).thenReturn(Optional.empty());

        boolean res = productService.deleteById(2L);
        assertFalse(res);
        verify(productRepository, times(1)).findById(2L);
    }
}
