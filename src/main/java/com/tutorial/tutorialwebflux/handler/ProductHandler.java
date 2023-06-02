package com.tutorial.tutorialwebflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tutorial.tutorialwebflux.entity.Product;
import com.tutorial.tutorialwebflux.service.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {
    
    private final ProductService service;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<Product> products = service.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(products, Product.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        int id = Integer.valueOf(request.pathVariable("id"));
        Mono<Product> product = service.getById(id);
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(product, Product.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<Product> product = request.bodyToMono(Product.class);
        return product.flatMap(p -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.save(p), Product.class));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.valueOf(request.pathVariable("id"));
        Mono<Product> product = request.bodyToMono(Product.class);
        return product.flatMap(p -> ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(service.update(id, p), Product.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(service.delete(id), Product.class);
    }
}
