package com.od.crowdy.user.config.routing;

import com.od.crowdy.user.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class UserRoutingConfigurer implements RoutingConfigurer {
    private final UserHandler userHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/users"), userHandler::findAllUsers)
                .andRoute(GET("/users/{id}"), userHandler::findUserById)
                .andRoute(POST("/users"), userHandler::saveUser)
                .andRoute(DELETE("/users/{id}"), userHandler::deleteUserById);
    }
}
