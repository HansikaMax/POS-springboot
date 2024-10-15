package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.Stock;
import com.IJSE.POS_Spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        
        Stock existingStock=stockRepository.findById(id).orElse(null);

        if(existingStock==null){
               return null;
        }else{
            existingStock.setItem(stock.getItem());
            existingStock.setQuantity(stock.getQuantity());
            existingStock.setTransctype(stock.getTransctype());
            return stockRepository.save(existingStock);
        }
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }
    
}
