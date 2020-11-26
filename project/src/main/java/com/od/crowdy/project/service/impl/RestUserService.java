package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.neo4j.model.User;
import com.od.crowdy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestUserService implements UserService {
    private final WebClient webClient;

    @Value("${userservice.uri}")
    private String userServiceUri;

    @Override
    public Mono<User> getAuthorByProjectId(String projectId) {
        return webClient.get()
                .uri(userServiceUri + "/users/project/" + projectId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class);
    }

    @Override
    public Flux<User> getUserLikesByProject(String projectId) {
        return webClient.get()
                .uri(userServiceUri + "/users/like/projects/" + projectId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class);
    }
}
