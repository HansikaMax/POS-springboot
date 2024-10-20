package com.IJSE.POS_Spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IJSE.POS_Spring.Entity.Item;
import com.IJSE.POS_Spring.Entity.Pos;
import com.IJSE.POS_Spring.Entity.Stock;
import com.IJSE.POS_Spring.dto.PosDto;
import com.IJSE.POS_Spring.service.ItemService;
import com.IJSE.POS_Spring.service.PosService;
import com.IJSE.POS_Spring.service.StockService;

@RestController
@CrossOrigin(origins="*")
public class PosController {
    
    @Autowired
    private PosService posService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @GetMapping("/poss")
    public ResponseEntity<List<Pos>> getAllPsos(){
        List<Pos> poss= posService.getAllPoss();

        return ResponseEntity.status(200).body(poss);
    }

   
    @PostMapping("/poss")
public ResponseEntity<Pos> createPos(@RequestBody PosDto posDto) {
    Pos pos = new Pos();
    pos.setTotalPrice(0.0);

    List<Long> itemIds = posDto.getItemIds();
    List<Long> quantities = posDto.getQuantities(); // Assuming you're passing quantities for each item

    List<Item> items = new ArrayList<>();

    for (int i = 0; i < itemIds.size(); i++) {
        Long itemId = itemIds.get(i);
       Long quantity = quantities.get(i);  // get the respective quantity for the item

        Item item = itemService.getItemById(itemId);
        if (item != null) {
            items.add(item);
            pos.setTotalPrice(pos.getTotalPrice() + (item.getPrice() * quantity));

            // Create a new stock entry with "OUT" transaction type
            Stock stock = new Stock();
            stock.setItem(item);
            stock.setQuantity(quantity);
            stock.setTransctype("OUT");  // Transaction type for orders is "OUT"
            stockService.createStock(stock);  // Assuming you have a createStock method in stockService
        }
    }

    pos.setPosItems(items);
    Pos createdPos = posService.createPos(pos);

    return ResponseEntity.status(201).body(createdPos);
}
}
