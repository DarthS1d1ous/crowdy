package com.od.crowdy.user.facade;

import com.od.crowdy.user.dto.AuthRequest;
import com.od.crowdy.user.dto.RegisterUserDto;
import com.od.crowdy.user.dto.UserDto;
import reactor.core.publisher.Mono;

public interface AuthFacade {
    Mono<UserDto> login(Mono<AuthRequest> authRequest);

    Mono<UserDto> register(Mono<RegisterUserDto> authRequest);
}
