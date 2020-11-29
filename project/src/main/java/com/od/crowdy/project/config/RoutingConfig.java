package com.od.crowdy.project.config;

import com.od.crowdy.project.handler.CategoryHandler;
import com.od.crowdy.project.handler.CommentHandler;
import com.od.crowdy.project.handler.FaqHandler;
import com.od.crowdy.project.handler.ProjectHandler;
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
public class RoutingConfig {

    @Bean
    RouterFunction<ServerResponse> routes(
        CategoryHandler categoryHandler,
        ProjectHandler projectHandler,
        FaqHandler faqHandler,
        CommentHandler commentHandler
    ) {
        return route(GET("/categories"), categoryHandler::getCategories)
            .andRoute(GET("/projects/{" + ProjectHandler.PROJECT_ID + "}"), projectHandler::getProjectById)
            .andRoute(GET("/faqs/project/{" + ProjectHandler.PROJECT_ID + "}"), faqHandler::getFaqsByProjectId)
            .andRoute(GET("/comments/project/{" + ProjectHandler.PROJECT_ID + "}"), commentHandler::getCommentsByProjectId)
            .andRoute(POST("/comments"), commentHandler::saveComment);
    }
}
