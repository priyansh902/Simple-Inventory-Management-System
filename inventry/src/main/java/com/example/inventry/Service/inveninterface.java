package com.example.inventry.Service;

import java.util.List;

import com.example.inventry.Dto.invendto;
import com.example.inventry.Model.model;

public interface inveninterface {
    model addInventory(invendto inventoryDTO);
    model updateInventory(Long id, invendto inventoryDTO);
    void deleteInventory(Long id);
    model getInventoryById(Long id);
    List<model> searchInventoryByName(String name);
    List<model> getAllInventory();
}
