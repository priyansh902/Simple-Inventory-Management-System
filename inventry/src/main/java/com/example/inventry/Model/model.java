package com.example.inventry.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "model")
public class model {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false)
    private String products;
   @Column(nullable = false)
    private int level;
   
    private String name;

    @Column(nullable = false)
    private double price;

    // public model (String products, int level, String name){
    //     this.products = products;
    //     this.level= level;
    //     this.name = name;
    // }

    
}
