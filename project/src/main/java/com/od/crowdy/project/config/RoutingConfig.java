package com.od.crowdy.project.config;

import com.od.crowdy.project.handler.CategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutingConfig {

    @Bean
    RouterFunction<ServerResponse> routes(CategoryHandler categoryHandler) {
        return route(GET("/categories"), categoryHandler::getCategories);
    }
}
