package com.IJSE.POS_Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IJSE.POS_Spring.Entity.ItemCategory;
import com.IJSE.POS_Spring.service.ItemCategoryService;

@RestController
public class ItemCategoryController {
    
    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ItemCategory>> getAllCategories(){

        List<ItemCategory> categories=itemCategoryService.getAllCategories();
       return ResponseEntity.status(200).body(categories);
         
    }
    
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        itemCategoryService.deleteCategoryById(categoryId);

        return ResponseEntity.status(200).body("Category successfully deleted");
    }

    @PostMapping("/categories")
    public ResponseEntity<ItemCategory> createCategory(@RequestBody ItemCategory itemCategory){

        ItemCategory category=new ItemCategory();
        category.setName(itemCategory.getName());

        ItemCategory createdCategory=itemCategoryService.createCategory(category);
        return ResponseEntity.status(201).body(createdCategory);

    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<ItemCategory> updateCategory(@RequestBody ItemCategory itemCategory, @PathVariable Long categoryId){

        ItemCategory category=new ItemCategory();
        category.setName(itemCategory.getName());

        ItemCategory updatedCategory=itemCategoryService.updateCategory(category, categoryId);
        return ResponseEntity.status(200).body(updatedCategory);

    }
}
