package com.IJSE.POS_Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJSE.POS_Spring.Entity.Item;
import com.IJSE.POS_Spring.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        
        Item existingItem=itemRepository.findById(id).orElse(null);

        if(existingItem==null){
            return null;
        }else{
            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            existingItem.setPrice(item.getPrice());
            existingItem.setCategory(item.getCategory());

            return itemRepository.save(existingItem);
        }
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteItem(Long id) {
     itemRepository.deleteById(id);
    }


}
