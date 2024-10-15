package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllCategories();
    ItemCategory createCategory(ItemCategory category);
    ItemCategory getCategoryById(Long id);
    ItemCategory updateCategory(ItemCategory category,Long id);
    void deleteCategoryById(Long id);
}
