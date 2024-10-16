package com.IJSE.POS_Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.IJSE.POS_Spring.Entity.Item;
import com.IJSE.POS_Spring.Entity.Stock;
import com.IJSE.POS_Spring.dto.StockDto;
import com.IJSE.POS_Spring.service.ItemService;
import com.IJSE.POS_Spring.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StockController {
    
    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> stocks= stockService.getAllStocks();

      return ResponseEntity.status(200).body(stocks);

    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody StockDto stockDto){
        Stock stock =new Stock();

        Item item=itemService.getItemById(stockDto.getItemId());

        stock.setItem(item);
        stock.setQuantity(stockDto.getQuantity());
        stock.setTransctype(stockDto.getTransctype());

        Stock createdStock=stockService.createStock(stock);
        return ResponseEntity.status(201).body(createdStock);
    }

    @PutMapping("/stocks/{stockId}")
    public ResponseEntity<Stock> updateStock(@RequestBody StockDto stockDto, @PathVariable Long stockId){
        Stock stock =new Stock();

        Item item=itemService.getItemById(stockDto.getItemId());

        stock.setItem(item);
        stock.setQuantity(stockDto.getQuantity());
        stock.setTransctype(stockDto.getTransctype());

        Stock updatedStock=stockService.updateStock(stockId, stock);
        return ResponseEntity.status(200).body(updatedStock);
    }
}
