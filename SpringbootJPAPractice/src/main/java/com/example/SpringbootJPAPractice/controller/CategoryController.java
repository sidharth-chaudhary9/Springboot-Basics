package com.example.SpringbootJPAPractice.controller;

import com.example.SpringbootJPAPractice.DTO.CategoryDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.repository.CategoryRepository;
import com.example.SpringbootJPAPractice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }


    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryDTO category){
        categoryService.createCategory(category);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Optional<Category> c1=categoryService.getCategoryById(id);
        if(c1.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Category c2=c1.get();
        return ResponseEntity.ok().body(c2);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
        boolean c1=categoryService.updateCategory(id,category);
        if(c1==false){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
        boolean a=categoryService.deleteCategory(id);
        if(a==true) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
