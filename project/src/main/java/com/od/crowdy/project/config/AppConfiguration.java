package com.od.crowdy.project.config;

import com.od.crowdy.project.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    private final ProjectHandler projectHandler;
    private final CategoriesHandler categoriesHandler;
    private final FaqHandler faqHandler;
    private final CommentHandler commentHandler;
    private final BackOptionHandler backOptionHandler;


    @Bean
    RouterFunction<ServerResponse> routes() {
        return route(GET("/projects/:id"), projectHandler::findProjectById)
                .andRoute(POST("/projects"), projectHandler::saveProject);
    }
}
