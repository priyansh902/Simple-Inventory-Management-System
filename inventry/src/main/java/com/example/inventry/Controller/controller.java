package com.example.inventry.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventry.Dto.invendto;
import com.example.inventry.Model.model;
import com.example.inventry.Service.service;

@RestController
@RequestMapping("/inventory")
public class controller {

    @Autowired
    public  service invenservice;

    @PostMapping
    public ResponseEntity<model> addInventory(@RequestBody invendto inventoryDTO){
        return  ResponseEntity.ok(invenservice.addInventory(inventoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<model> updateInventory(@PathVariable Long id, @RequestBody invendto inventoryDTO){
        return ResponseEntity.ok(invenservice.updateInventory(id, inventoryDTO));
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        invenservice.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<model> getInventoryById(@PathVariable Long id) {
        return ResponseEntity.ok(invenservice.getInventoryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<model>> searchInventoryByName(@RequestParam String name) {
        return ResponseEntity.ok(invenservice.searchInventoryByName(name));
    }

    @GetMapping
    public ResponseEntity<List<model>> getAllInventory() {
        return ResponseEntity.ok(invenservice.getAllInventory());
    }


    // @GetMapping
    // public List<model> getallitems(){
    //     return invenservice.getallitems();
    // }

    // @GetMapping("/{id}")
    // public model getitem(@PathVariable Long id){
    //     return invenservice.getitem(id);
    // }

    // @PostMapping
    // public model createitem(@RequestBody model inven){
    //     return invenservice.createitem(inven);
    // }

    // @PutMapping("/{id}")
    // public model updateinven(@PathVariable Long id, @RequestBody model inven){
    //     return invenservice.updateinven(id, inven);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteinven(@PathVariable Long id){
    //     invenservice.deleteinven(id);
    //     return ResponseEntity.noContent().build();
}

    

