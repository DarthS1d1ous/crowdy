package com.od.crowdy.user.helper.impl;

import com.od.crowdy.user.domain.neo4j.RoleRepository;
import com.od.crowdy.user.domain.neo4j.model.Role;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.helper.UserHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserHelper implements UserHelper {
    private final RoleRepository roleRepository;

    @Override
    public Mono<UserDto> fillRoles(UserDto userDto) {
        return roleRepository.getRolesByUserId(userDto.getId())
            .map(Role::toDto)
            .collectList()
            .doOnNext(userDto::setRoles)
            .thenReturn(userDto);
    }
}
