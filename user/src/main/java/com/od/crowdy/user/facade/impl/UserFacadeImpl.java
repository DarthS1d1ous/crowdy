package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
import com.od.crowdy.user.facade.UserFacade;
import com.od.crowdy.user.helper.UserHelper;
import com.od.crowdy.user.request.FollowRequest;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserHelper userHelper;

    @Override
    public Flux<UserDto> getUserLikesByProjectId(String projectId) {
        return this.userService.getUserLikesByProjectId(projectId)
            .map(UserDto::from)
            .flatMap(userHelper::fillUserRoles);
    }

    @Override
    public Mono<UserDto> getAuthorByCommentId(String commentId) {
        return this.userService.getAuthorByCommentId(commentId)
            .map(UserDto::from)
            .flatMap(userHelper::fillUserRoles);
    }

    @Override
    public Mono<UserDto> getUserById(String userId) {
        return this.userService.getUserById(userId)
            .map(UserDto::from)
            .flatMap(userHelper::fillUserRoles);
    }

    @Override
    public Mono<UserDto> getAuthorByProjectId(String projectId) {
        return this.userService.getAuthorByProjectId(projectId)
            .map(UserDto::from)
            .flatMap(userHelper::fillUserRoles);
    }

    @Override
    public Mono<UserProfileDto> getUserProfileByUserId(String userId) {
        return this.userService.getUserById(userId)
            .map(UserProfileDto::from)
            .flatMap(this.userHelper::fillUserRoles)
            .flatMap(this.userHelper::fillUserFollowers)
            .flatMap(this.userHelper::fillUserFollowing)
            .flatMap(this.userHelper::fillUserCreatedProjects)
            .flatMap(this.userHelper::fillUserBackedProjects);
    }

    @Override
    public Mono<UserProfileDto> saveUserFollower(Mono<FollowRequest> request) {
        return request.flatMap(followRequest ->
            this.userService.saveUserFollower(followRequest.getFollowerUserId(), followRequest.getFollowingUserId()))
            .map(UserProfileDto::from)
            .flatMap(this.userHelper::fillUserRoles)
            .flatMap(this.userHelper::fillUserFollowers)
            .flatMap(this.userHelper::fillUserFollowing)
            .flatMap(this.userHelper::fillUserCreatedProjects)
            .flatMap(this.userHelper::fillUserBackedProjects);
    }

    @Override
    public Mono<UserProfileDto> deleteUserFollower(String followerId, String followingId) {
        return this.userService.deleteUserFollower(followerId, followingId)
            .map(UserProfileDto::from)
            .flatMap(this.userHelper::fillUserRoles)
            .flatMap(this.userHelper::fillUserFollowers)
            .flatMap(this.userHelper::fillUserFollowing)
            .flatMap(this.userHelper::fillUserCreatedProjects)
            .flatMap(this.userHelper::fillUserBackedProjects);
    }
}
