package com.od.crowdy.user.helper.impl;

import com.od.crowdy.user.domain.neo4j.model.Role;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.helper.UserHelper;
import com.od.crowdy.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHelperImpl implements UserHelper {
    private final RoleService roleService;

    @Override
    public Mono<UserDto> fillUserRoles(UserDto userDto) {
        return this.roleService.getRolesByUserId(userDto.getId())
            .map(Role::toDto)
            .collectList()
            .doOnNext(userDto::setRoles)
            .thenReturn(userDto);
    }
}
