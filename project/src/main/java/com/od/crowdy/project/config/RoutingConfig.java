package com.od.crowdy.project.config;

import com.od.crowdy.project.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutingConfig {

    @Bean
    RouterFunction<ServerResponse> routes(
        CategoryHandler categoryHandler,
        ProjectHandler projectHandler,
        FaqHandler faqHandler,
        CommentHandler commentHandler,
        BackOptionHandler backOptionHandler
    ) {
        return route(GET("/categories"), categoryHandler::getCategories)
            .andRoute(GET("/projects/{" + ProjectHandler.PROJECT_ID + "}"), projectHandler::getProjectById)
            .andRoute(GET("/faqs/project/{" + ProjectHandler.PROJECT_ID + "}"), faqHandler::getFaqsByProjectId)
            .andRoute(
                GET("/projects/{" + ProjectHandler.PROJECT_ID + "}/comments"),
                commentHandler::getCommentsByProjectId
            )
            .andRoute(POST("/comments"), commentHandler::saveComment)
            .andRoute(PUT("/comments"), commentHandler::updateComment)
            .andRoute(
                GET("/backoptions/project/{" + ProjectHandler.PROJECT_ID + "}"),
                backOptionHandler::getBackOptionsByProjectId
            )
            .andRoute(
                GET("/projects/created/users/{" + ProjectHandler.USER_ID + "}"),
                projectHandler::getCreatedProjectsByUserId
            )
            .andRoute(
                GET("/projects/backed/users/{" + ProjectHandler.USER_ID + "}"),
                projectHandler::getBackedProjectsByUserId
            )
            .andRoute(
                POST("/users/like/projects"),
                projectHandler::saveProjectLike
            )
            .andRoute(
                DELETE("/users/{" + ProjectHandler.USER_ID + "}/dislike/projects/{" + ProjectHandler.PROJECT_ID + "}"),
                projectHandler::deleteProjectLike
            )
            .andRoute(
                GET("/projectsDetails/{" + ProjectHandler.PROJECT_ID + "}"),
                projectHandler::getProjectDetailsByProjectId
            );
    }
}
