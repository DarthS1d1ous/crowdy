package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.BackOptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class BackOptionRoutingConfigurer implements RoutingConfigurer {
    private final BackOptionHandler backOptionHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/backoptions"), backOptionHandler::findAllBackOptions)
                .andRoute(GET("/backoptions/:id"), backOptionHandler::findBackOptionById)
                .andRoute(POST("/backoptions"), backOptionHandler::saveBackOption)
                .andRoute(DELETE("/backoptions/:id"), backOptionHandler::deleteBackOptionById);
    }
}
