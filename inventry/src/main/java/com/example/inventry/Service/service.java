package com.example.inventry.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventry.Dto.invendto;
import com.example.inventry.Model.model;
import com.example.inventry.Repositiory.repositiory;
import com.example.inventry.exception.Customex;

@Service
public class service  implements inveninterface{
    @Autowired
   private repositiory inventoryrespositiory;

   

    public List<model> getallitems() {
        return inventoryrespositiory.findAll();
    }

    public model getitem(Long id){
        return inventoryrespositiory.findById(id)
        .orElseThrow(() -> new RuntimeException(" item not found in inventary " + id));
    }

    public model createitem(model inven){
        return inventoryrespositiory.save(inven);
    }

    public model updateinven(Long id, model updateinven){
         model existinginven = getitem(id);
         existinginven.setName(updateinven.getName());
         existinginven.setLevel(updateinven.getLevel());
         existinginven.setProducts(updateinven.getProducts());
        return inventoryrespositiory.save(existinginven);
    }

    public void deleteinven(Long id){
        inventoryrespositiory.deleteById(id);
    }

    @Override
    public model addInventory(invendto inventoryDTO) {
         model inventory = new model();
         inventory.setName(inventoryDTO.getName());
         inventory.setLevel(inventoryDTO.getLevel());
         inventory.setProducts(inventoryDTO.getProducts());
         inventory.setPrice(inventoryDTO.getPrice());
         return inventoryrespositiory.save(inventory);
    }

    @Override
    public model updateInventory(Long id, invendto inventoryDTO) {
       model inventory = inventoryrespositiory.findById(id)
       .orElseThrow(()-> new Customex("inventory not found "));
       inventory.setName(inventoryDTO.getName());
       inventory.setLevel(inventoryDTO.getLevel());
       inventory.setProducts(inventoryDTO.getProducts());
       inventory.setPrice(inventoryDTO.getPrice());
       return inventoryrespositiory.save(inventory);
    }

    @Override
    public void deleteInventory(Long id) {
       if(!inventoryrespositiory.existsById(id)) {
        throw new Customex("inventory not found ");
       }
       inventoryrespositiory.deleteById(id);
    }

    @Override
    public model getInventoryById(Long id) {
       return inventoryrespositiory.findById(id)
       .orElseThrow(()-> new Customex("inventory not found "));
    }

    @Override
    public List<model> searchInventoryByName(String name) {
        return inventoryrespositiory.findByName(name);
    }

    @Override
    public List<model> getAllInventory() {
       return inventoryrespositiory.findAll();
    }
}
