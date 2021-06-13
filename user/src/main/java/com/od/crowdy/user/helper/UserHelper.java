package com.od.crowdy.user.helper;

import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
import reactor.core.publisher.Mono;

public interface UserHelper {
    <T extends UserDto> Mono<T> fillUserRoles(T userDto);

    Mono<UserProfileDto> fillUserFollowers(UserProfileDto userProfileDto);

    Mono<UserProfileDto> fillUserFollowing(UserProfileDto userProfileDto);

    Mono<UserProfileDto> fillUserCreatedProjects(UserProfileDto userProfileDto);

    Mono<UserProfileDto> fillUserBackedProjects(UserProfileDto userProfileDto);
}
