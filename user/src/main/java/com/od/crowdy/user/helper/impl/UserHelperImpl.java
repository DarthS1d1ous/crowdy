package com.od.crowdy.user.helper.impl;

import com.od.crowdy.user.domain.neo4j.model.Role;
import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
import com.od.crowdy.user.helper.UserHelper;
import com.od.crowdy.user.service.ProjectService;
import com.od.crowdy.user.service.RoleService;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHelperImpl implements UserHelper {
    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;

    @Override
    public <T extends UserDto> Mono<T> fillUserRoles(T userDto) {
        return this.roleService.getRolesByUserId(userDto.getId())
            .map(Role::toDto)
            .collectList()
            .doOnNext(userDto::setRoles)
            .thenReturn(userDto);
    }

    @Override
    public Mono<UserProfileDto> fillUserFollowers(UserProfileDto userProfileDto) {
        return this.userService.getFollowersByUserId(userProfileDto.getId())
            .map(User::toDto)
            .collectList()
            .doOnNext(userProfileDto::setFollowers)
            .thenReturn(userProfileDto);
    }

    @Override
    public Mono<UserProfileDto> fillUserFollowing(UserProfileDto userProfileDto) {
        return this.userService.getFollowingByUserId(userProfileDto.getId())
            .map(User::toDto)
            .collectList()
            .doOnNext(userProfileDto::setFollowing)
            .thenReturn(userProfileDto);
    }

    @Override
    public Mono<UserProfileDto> fillUserCreatedProjects(UserProfileDto userProfileDto) {
        return this.projectService.getCreatedProjectsByUserId(userProfileDto.getId())
            .collectList()
            .doOnNext(userProfileDto::setCreatedProjects)
            .thenReturn(userProfileDto);
    }

    @Override
    public Mono<UserProfileDto> fillUserBackedProjects(UserProfileDto userProfileDto) {
        return this.projectService.getBackedProjectsByUserId(userProfileDto.getId())
            .collectList()
            .doOnNext(userProfileDto::setBackedProjects)
            .thenReturn(userProfileDto);
    }
}
