package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.dao.UserRepository;
import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {
    private final UserRepository userRepository;
    private final ReactiveNeo4jOperations neo4jOperations;

    @Override
    public Mono<UserDto> getAuthorByProjectId(String projectId) {
        return userRepository.getAuthorByProjectId(projectId)
            .map(User::toDto);
    }

    @Override
    public Mono<UserDto> save(Mono<UserDto> user) {
        return user.flatMap(userDto -> userRepository.save(User.from(userDto)))
            .map(User::toDto);
    }

    @Override
    public Flux<UserDto> getUserLikesByProjectId(String projectId) {
        return userRepository
            .getUserLikesByProjectId(projectId)
            .map(User::toDto);
    }

    @Override
    public Flux<UserDto> getFollowersByUserId(String userId) {
        return userRepository.findFollowersByUserId(userId)
            .map(User::toDto);
    }

    @Override
    public Mono<UserDto> getAuthorByCommentId(String commentId) {
        return userRepository.findAuthorByCommentId(commentId)
            .map(User::toDto);
    }

    @Override
    public Mono<UserDto> getUserById(String userId) {
        return neo4jOperations.findById(userId, User.class)
            .map(User::toDto);
    }
}
