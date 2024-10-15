package com.IJSE.POS_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJSE.POS_Spring.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
    
}
