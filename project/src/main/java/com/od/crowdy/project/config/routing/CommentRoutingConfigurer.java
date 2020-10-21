package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.CommentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class CommentRoutingConfigurer implements RoutingConfigurer {
    private final CommentHandler commentHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/comments"), commentHandler::findAllComments)
                .andRoute(GET("/comments/{id}"), commentHandler::findCommentById)
                .andRoute(POST("/comments"), commentHandler::saveComment)
                .andRoute(DELETE("/comments/{id}"), commentHandler::deleteCommentById);
    }
}
