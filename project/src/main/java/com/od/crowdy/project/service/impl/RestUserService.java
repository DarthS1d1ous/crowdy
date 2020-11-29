package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.dto.UserDto;
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
    public Mono<UserDto> getAuthorByProjectId(String projectId) {
        return webClient.get()
            .uri(userServiceUri + "/users/project/" + projectId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(UserDto.class);
    }

    @Override
    public Flux<UserDto> getUserLikesByProject(String projectId) {
        return webClient.get()
            .uri(userServiceUri + "/users/like/projects/" + projectId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(UserDto.class);
    }

    @Override
    public Mono<UserDto> getAuthorByCommentId(String commentId) {
        return webClient.get()
            .uri(userServiceUri + "/users/comment/" + commentId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(UserDto.class);
    }

    @Override
    public Mono<UserDto> getUserById(String userId) {
        return webClient.get()
            .uri(userServiceUri + "/users/" + userId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(UserDto.class);
    }
}
