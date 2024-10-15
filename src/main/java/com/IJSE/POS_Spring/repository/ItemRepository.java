package com.IJSE.POS_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJSE.POS_Spring.Entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
    
}
