package com.od.crowdy.user.domain.neo4j.repository;

import com.od.crowdy.user.domain.neo4j.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> save(User user);

    Mono<User> getUserByUsername(String username);

    Mono<Boolean> isUserExists(String username);

    Flux<User> getUserLikesByProjectId(String projectId);

    Mono<User> getUserById(String userId);

    Mono<User> getAuthorByCommentId(String commentId);

    Mono<User> getAuthorByProjectId(String projectId);

    Flux<User> getFollowersByUserId(String userId);

    Flux<User> getFollowingByUserId(String userId);

    Mono<User> saveUserFollower(String followerUserId, String followingUserId);

    Mono<User> deleteUserFollower(String followerId, String followingId);
}
