package com.IJSE.POS_Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.IJSE.POS_Spring.Entity.Item;
import com.IJSE.POS_Spring.Entity.ItemCategory;
import com.IJSE.POS_Spring.dto.ItemDto;
import com.IJSE.POS_Spring.service.ItemCategoryService;
import com.IJSE.POS_Spring.service.ItemService;

@Controller
@CrossOrigin(origins="*")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService categoryService;


    @GetMapping("/items")
public ResponseEntity<List<Item>> getAllItems(){

    List<Item> items= itemService.getAllItems();
    return ResponseEntity.status(200).body(items);

}

    @DeleteMapping("items/{itemId}")
 public ResponseEntity<String> deleteItem(@PathVariable Long itemId){
      itemService.deleteItem(itemId);

      return ResponseEntity.status(200).body("Item successfully deleted");
 }

    @PostMapping("/items")
public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDto){

    Item item=new Item();
    item.setName(itemDto.getName());
    item.setPrice(itemDto.getPrice());
    item.setDescription(itemDto.getDescription());

    ItemCategory category= categoryService.getCategoryById(itemDto.getCategoryId());
    item.setCategory(category);

    Item createdItem=itemService.createItem(item);
    return ResponseEntity.status(201).body(createdItem);
}

    @PutMapping("/items/{itemId}")
public ResponseEntity<Item> updateItem(@RequestBody ItemDto itemDto, @PathVariable Long itemId){

    Item item=new Item();
    item.setName(itemDto.getName());
    item.setPrice(itemDto.getPrice());
    item.setDescription(itemDto.getDescription());

    ItemCategory category= categoryService.getCategoryById(itemDto.getCategoryId());
    item.setCategory(category);

    Item updatedItem= itemService.updateItem(itemId, item);
    return ResponseEntity.status(200).body(updatedItem);
}

}
