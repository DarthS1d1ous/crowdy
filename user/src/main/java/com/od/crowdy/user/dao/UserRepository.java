package com.od.crowdy.user.dao;

import com.od.crowdy.user.domain.neo4j.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> getAuthorByProjectId(String projectId);

    Mono<User> save(User user);

    Mono<User> findByUsername(String username);

    Flux<User> getUserLikesByProjectId(String projectId);

    Mono<Boolean> isUserExists(String username);

    Flux<User> findFollowersByUserId(String userId);

    Flux<User> findFollowingByUserId(String userId);

    Mono<User> findAuthorByCommentId(String commentId);

    Mono<User> getUserById(String userId);
}
