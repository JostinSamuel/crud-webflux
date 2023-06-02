package com.tutorial.tutorialwebflux.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.tutorialwebflux.entity.Product;
import com.tutorial.tutorialwebflux.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping
    public Flux<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable("id") int id) {
        return productService.getById(id);    
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product product) {
        return productService.save(product);    
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.update(id, product);    
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") int id) {
        return productService.delete(id);    
    }
}
