package com.od.crowdy.user.config.routing;

import com.od.crowdy.user.handler.UserRolesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@RequiredArgsConstructor
public class UserRolesRoutingConfigurer implements RoutingConfigurer {
    private final UserRolesHandler userRolesHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/userroles"), userRolesHandler::findAllUserRoles)
                .andRoute(GET("/userroles/:id"), userRolesHandler::findUserRoleById)
                .andRoute(POST("/userroles"), userRolesHandler::saveUserRole)
                .andRoute(DELETE("/userroles/:id"), userRolesHandler::deleteUserRoleById);
    }
}
