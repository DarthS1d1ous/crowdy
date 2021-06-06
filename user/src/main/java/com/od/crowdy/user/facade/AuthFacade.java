package com.od.crowdy.user.facade;

import com.od.crowdy.user.dto.RegisterUserDto;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.request.AuthRequest;
import reactor.core.publisher.Mono;

public interface AuthFacade {
    Mono<UserDto> login(Mono<AuthRequest> authRequest);

    Mono<UserDto> register(Mono<RegisterUserDto> authRequest);
}
