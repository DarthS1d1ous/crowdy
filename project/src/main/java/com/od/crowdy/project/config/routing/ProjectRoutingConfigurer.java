package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.ProjectHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class ProjectRoutingConfigurer implements RoutingConfigurer {
    private final ProjectHandler projectHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/projects"), projectHandler::findAllProjects)
                .andRoute(GET("/projects/:id"), projectHandler::findProjectById)
                .andRoute(POST("/projects"), projectHandler::saveProject)
                .andRoute(DELETE("/projects/:id"), projectHandler::deleteProjectById);
    }
}
