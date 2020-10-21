package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.CategoriesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class CategoriesRoutingConfigurer implements RoutingConfigurer {
    private final CategoriesHandler categoriesHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/categories"), categoriesHandler::findAllCategories)
                .andRoute(GET("/categories/{id}"), categoriesHandler::findCategoryById)
                .andRoute(POST("/categories"), categoriesHandler::saveCategory)
                .andRoute(DELETE("/categories/{id}"), categoriesHandler::deleteCategoryById);
    }
}
