package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.dao.neo4j.model.User;
import com.od.crowdy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RestUserService implements UserService {
    private final WebClient webClient;

    @Value("${userservice.uri}")
    private String userServiceUri;

    @Override
    public Mono<User> getAuthor(String projectId) {
        return webClient.get()
                .uri(userServiceUri + "/users/project/" + projectId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class);
    }
}
