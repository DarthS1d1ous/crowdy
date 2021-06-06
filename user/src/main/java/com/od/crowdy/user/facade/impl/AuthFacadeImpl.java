package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.dto.RegisterUserDto;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.facade.AuthFacade;
import com.od.crowdy.user.helper.UserHelper;
import com.od.crowdy.user.request.AuthRequest;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthFacadeImpl implements AuthFacade {
    private final UserService userService;
    private final UserHelper userHelper;

    @Override
    public Mono<UserDto> login(Mono<AuthRequest> authRequest) {
        return authRequest.flatMap(this.userService::login)
            .map(User::toDto)
            .flatMap(this.userHelper::fillUserRoles);
    }

    @Override
    public Mono<UserDto> register(Mono<RegisterUserDto> authRequest) {
        return authRequest.map(RegisterUserDto::toModel)
            .flatMap(this.userService::registerUser)
            .map(User::toDto)
            .flatMap(this.userHelper::fillUserRoles);
    }
}
