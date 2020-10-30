package com.od.crowdy.user.config.routing;

import com.od.crowdy.user.handler.UserRoleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@RequiredArgsConstructor
public class UserRoleRoutingConfigurer implements RoutingConfigurer {
    private final UserRoleHandler userRoleHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/userroles"), userRoleHandler::findAllUserRoles)
                .andRoute(GET("/userroles/{id}"), userRoleHandler::findUserRoleById)
                .andRoute(POST("/userroles"), userRoleHandler::saveUserRole)
                .andRoute(DELETE("/userroles/{id}"), userRoleHandler::deleteUserRoleById);
    }
}
