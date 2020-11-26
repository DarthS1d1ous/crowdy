package com.od.crowdy.project.service;

import com.od.crowdy.project.domain.neo4j.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getAuthorByProjectId(String projectId);

    Flux<User> getUserLikesByProject(String projectDto);
}
