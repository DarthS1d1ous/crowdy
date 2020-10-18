package com.od.crowdy.auth.config;

import com.od.crowdy.auth.handler.AuthHandler;
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

    private final AuthHandler authHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route(GET("/auth"), authHandler::auth);
    }
}
