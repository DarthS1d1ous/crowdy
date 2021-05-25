package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.domain.neo4j.repository.UserRepository;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
import com.od.crowdy.user.facade.UserFacade;
import com.od.crowdy.user.helper.UserHelper;
import com.od.crowdy.user.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {
    private final UserRepository userRepository;
    private final UserHelper userHelper;
    private final ProjectService projectService;
    private final ReactiveNeo4jOperations neo4jOperations;

    @Override
    public Mono<UserDto> getAuthorByProjectId(String projectId) {
        return userRepository.getAuthorByProjectId(projectId)
            .map(User::toDto)
            .flatMap(userHelper::fillRoles);
    }

    @Override
    public Mono<UserDto> save(Mono<UserDto> user) {
        return user.flatMap(userDto -> userRepository.save(User.from(userDto)))
            .map(User::toDto)
            .flatMap(userHelper::fillRoles);
    }

    @Override
    public Flux<UserDto> getUserLikesByProjectId(String projectId) {
        return userRepository
            .getUserLikesByProjectId(projectId)
            .map(User::toDto)
            .flatMap(userHelper::fillRoles);
    }

    @Override
    public Flux<UserDto> getFollowersByUserId(String userId) {
        return userRepository.findFollowersByUserId(userId)
            .map(User::toDto)
            .flatMap(userHelper::fillRoles);
    }

    @Override
    public Mono<UserDto> getAuthorByCommentId(String commentId) {
        return userRepository.findAuthorByCommentId(commentId)
            .map(User::toDto)
            .flatMap(userHelper::fillRoles);
    }

    @Override
    public Mono<UserDto> getUserById(String userId) {
        return neo4jOperations.findById(userId, User.class)
            .map(User::toDto)
            .flatMap(userHelper::fillRoles);
    }

    @Override
    public Mono<UserProfileDto> getUserProfileById(String userId) {
        return userRepository.getUserById(userId)
            .map(UserProfileDto::from)
            .flatMap(userProfileDto -> projectService.getProjectsByUserId(userId)
                .collectList()
                .doOnNext(userProfileDto::setProjects)
                .thenMany(userRepository.findFollowersByUserId(userId))
                .map(User::toDto)
                .collectList()
                .doOnNext(userProfileDto::setFollowers)
                .thenMany(userRepository.findFollowingByUserId(userId))
                .map(User::toDto)
                .collectList()
                .doOnNext(userProfileDto::setFollowing)
                .then(Mono.just(userProfileDto))
            );
    }
}
