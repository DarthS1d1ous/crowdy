package com.od.crowdy.user.service;

import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.request.AuthRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
//    Mono<User> save(User user);
//
//    Mono<Boolean> isUserExists(String username);

    Mono<User> registerUser(User user);

    Mono<User> login(AuthRequest authRequest);

    Flux<User> getUserLikesByProjectId(String projectDto);

    Mono<User> getAuthorByCommentId(String commentId);

    Mono<User> getUserById(String userId);

    Mono<User> getAuthorByProjectId(String projectId);

}
