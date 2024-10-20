package com.IJSE.POS_Spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.Stock;
import com.IJSE.POS_Spring.dto.StockRemainingDto;
import com.IJSE.POS_Spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    

    public List<StockRemainingDto> calculateRemainingStock() {
        // Query to get the sum of quantities for each item
        String query = "SELECT item_id, SUM(CASE WHEN transctype = 'IN' THEN quantity ELSE -quantity END) as remaining "
                     + "FROM stock GROUP BY item_id";
    
        return jdbcTemplate.query(query, new RowMapper<StockRemainingDto>() {
            @Override
            public StockRemainingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                StockRemainingDto dto = new StockRemainingDto();
                dto.setItemId(rs.getInt("item_id"));
                dto.setRemaining(rs.getInt("remaining"));
                return dto;
            }
        });
    }

}
