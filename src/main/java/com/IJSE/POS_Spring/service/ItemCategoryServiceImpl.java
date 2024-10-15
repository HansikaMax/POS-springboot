package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.ItemCategory;
import com.IJSE.POS_Spring.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategories() {
       return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory createCategory(ItemCategory category) {
        return itemCategoryRepository.save(category);
    }

    @Override
    public ItemCategory getCategoryById(Long id) {
        return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategory updateCategory(ItemCategory category, Long id) {
       
        ItemCategory existingCategory=itemCategoryRepository.findById(id).orElse(null);

        if(existingCategory==null){
            return null;
        }else{
            existingCategory.setName(category.getName());
            return itemCategoryRepository.save(existingCategory);
        }
    }

    @Override
    public void deleteCategoryById(Long id) {
       itemCategoryRepository.deleteById(id);
    }

    
    
}
