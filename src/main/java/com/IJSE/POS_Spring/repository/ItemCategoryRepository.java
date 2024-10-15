package com.IJSE.POS_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJSE.POS_Spring.Entity.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
    
}
