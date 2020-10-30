package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.CategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class CategoryRoutingConfigurer implements RoutingConfigurer {
    private final CategoryHandler CategoryHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/category"), CategoryHandler::findAllCategory)
                .andRoute(GET("/category/{id}"), CategoryHandler::findCategoryById)
                .andRoute(POST("/category"), CategoryHandler::saveCategory)
                .andRoute(DELETE("/category/{id}"), CategoryHandler::deleteCategoryById);
    }
}
