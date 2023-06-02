package com.tutorial.tutorialwebflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tutorial.tutorialwebflux.handler.ProductHandler;

@Configuration
public class ProductRouter {

    private static final String PATH = "/product";

    @Bean
    RouterFunction<ServerResponse> router(ProductHandler handler) {
        return RouterFunctions.route()
            .GET(PATH, handler::getAll)
            .GET(PATH+"/{id}", handler::getById)
            .POST(PATH, handler::save)
            .PUT(PATH+"/{id}", handler::update)
            .DELETE(PATH+"/{id}",handler::delete)
            .build();
    }
    
}
