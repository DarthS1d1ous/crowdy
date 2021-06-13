package com.od.crowdy.user.facade;

import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
import com.od.crowdy.user.request.FollowRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserFacade {
    Flux<UserDto> getUserLikesByProjectId(String projectId);

    Mono<UserDto> getAuthorByCommentId(String commentId);

    Mono<UserDto> getUserById(String userId);

    Mono<UserDto> getAuthorByProjectId(String projectId);

    Mono<UserProfileDto> getUserProfileByUserId(String userId);

    Mono<UserProfileDto> saveUserFollower(Mono<FollowRequest> request);

    Mono<UserProfileDto> deleteUserFollower(String followerId, String followingId);
}
