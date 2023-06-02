package com.tutorial.tutorialwebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.tutorialwebflux.entity.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer>{
    
}
