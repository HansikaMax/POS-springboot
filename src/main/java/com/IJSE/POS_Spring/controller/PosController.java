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
import com.IJSE.POS_Spring.dto.PosDto;
import com.IJSE.POS_Spring.service.ItemService;
import com.IJSE.POS_Spring.service.PosService;

@RestController
@CrossOrigin(origins="*")
public class PosController {
    
    @Autowired
    private PosService posService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/poss")
    public ResponseEntity<List<Pos>> getAllPsos(){
        List<Pos> poss= posService.getAllPoss();

        return ResponseEntity.status(200).body(poss);
    }

    @PostMapping("/poss")
    public ResponseEntity<Pos> cretaePos(@RequestBody PosDto posDto){

        Pos pos=new Pos();
        pos.setTotalPrice(0.0);

        List<Long> itemIds=posDto.getItemIds();

        List<Item> items=new ArrayList<>(); 

        itemIds.forEach(itemId->{
            Item item=itemService.getItemById(itemId);
            if(item!=null){
                items.add(item);

                pos.setTotalPrice(pos.getTotalPrice()+item.getPrice());
            }
        });

        pos.setPosItems(items);
        Pos createdPos=posService.createPos(pos);

        return ResponseEntity.status(201).body(createdPos);


    }
}
