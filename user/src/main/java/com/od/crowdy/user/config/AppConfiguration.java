package com.od.crowdy.user.config;

import com.od.crowdy.user.handler.DummyHelloHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    private final DummyHelloHandler dummyHelloHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route(GET("/hello"), dummyHelloHandler::hello);
    }
}
