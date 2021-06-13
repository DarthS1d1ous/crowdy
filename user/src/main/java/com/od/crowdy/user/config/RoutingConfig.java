package com.od.crowdy.user.config;

import com.od.crowdy.user.handler.AuthHandler;
import com.od.crowdy.user.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutingConfig {

    @Bean
    @ResponseBody
    RouterFunction<ServerResponse> routes(UserHandler userHandler, AuthHandler authHandler) {
        return route(POST("/register"), authHandler::register)
            .andRoute(POST("/login"), authHandler::login)
            .andRoute(
                GET("/users/like/projects/{" + UserHandler.PROJECT_ID + "}"),
                userHandler::getUserLikesByProjectId
            )
            .andRoute(GET("/users/comment/{" + UserHandler.COMMENT_ID + "}"), userHandler::getAuthorByCommentId)
            .andRoute(GET("/users/{" + UserHandler.USER_ID + "}"), userHandler::getUserById)
            .andRoute(GET("/users/project/{" + UserHandler.PROJECT_ID + "}"), userHandler::getAuthorByProjectId)
            .andRoute(GET("/userProfiles/{" + UserHandler.USER_ID + "}"), userHandler::getUserProfileByUserId)
            .andRoute(POST("/users/follow/users"), userHandler::saveUserFollower)
            .andRoute(
                DELETE("/users/{" + UserHandler.FOLLOWER_ID + "}/follow/users/{" + UserHandler.FOLLOWING_ID + "}"),
                userHandler::deleteUserFollower
            );

    }
}
