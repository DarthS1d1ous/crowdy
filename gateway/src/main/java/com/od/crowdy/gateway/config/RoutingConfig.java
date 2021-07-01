package com.od.crowdy.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/categories")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.method("GET")
                .and()
                .path("/projects/{id}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.path("/faqs/project/{id}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.path("/projects/{id}/comments")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.method("POST")
                .and()
                .path("/comments")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.method("PUT")
                .and()
                .path("/comments")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.path("/backoptions/project/{id}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.path("/projects/created/users/{id}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.path("/projects/backed/users/{id}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.method("POST")
                .and()
                .path("/users/like/projects")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.method("DELETE")
                .and()
                .path("/users/{userId}/dislike/projects/{projectId}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))
            .route(r -> r.path("/projectsDetails/{id}")
                .uri("lb://PROJECT-SERVICE")
                .id("project-service"))

            .route(r -> r.method("POST")
                .and()
                .path("/register")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.method("POST")
                .and()
                .path("/login")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.path("/users/like/projects/{id}")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.path("/users/comment/{id}")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.method("GET")
                .and()
                .path("/users/{id}")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.path("/users/project/{id}")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.path("/userProfiles/{id}")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.method("POST")
                .and()
                .path("/users/follow/users")
                .uri("lb://USER-SERVICE")
                .id("user-service"))
            .route(r -> r.method("DELETE")
                .and()
                .path("/users/{followerId}/follow/users/{followingId}")
                .uri("lb://USER-SERVICE")
                .id("user-service"))

            .build();
    }
}