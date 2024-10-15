package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.Stock;

@Service
public interface StockService {
    
    List<Stock> getAllStocks();  
    Stock createStock (Stock stock);
    Stock updateStock(Long id, Stock stock);
    Stock getStockById(Long id);
}
