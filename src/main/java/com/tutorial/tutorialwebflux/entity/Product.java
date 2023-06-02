package com.tutorial.tutorialwebflux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    
    @Id
    private int id;   
    private String name;
    private float price;
}
