package com.example.SpringbootJPAPractice.service;

import com.example.SpringbootJPAPractice.DTO.CategoryDTO;
import com.example.SpringbootJPAPractice.DTO.ProductDTO;
import com.example.SpringbootJPAPractice.entity.Category;
import com.example.SpringbootJPAPractice.entity.Product;
import com.example.SpringbootJPAPractice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServ {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void createCategory(CategoryDTO categoryDTO){
        Category c1=new Category();
        c1.setName(categoryDTO.getName());
        if(categoryDTO.getProducts()!=null){
            int size=categoryDTO.getProducts().size();
            List<Product> productList = new ArrayList<>();
            for(int i=0;i<size;i++){
                Product insideCate=categoryDTO.getProducts().get(i);
                Product product=new Product();
                product.setName(insideCate.getName());
                product.setCategory(c1);
                product.setDescription(insideCate.getDescription());
                product.setStock(insideCate.getStock());
                productList.add(product);
            }
            c1.setProducts(productList);
        }
        categoryRepository.save(c1);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public boolean updateCategory(Long id, Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if(existingCategory.isPresent()) {
            Category c1 = existingCategory.get();
            c1.setName(category.getName());
            categoryRepository.save(c1);
            return true;
        }
        return false;
    }

    private Category getCategory(Category newCategory, Optional<Category> c1) {
        Category category = c1.get();
        category.setName(newCategory.getName());
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(Long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
