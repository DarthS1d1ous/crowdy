package com.od.crowdy.user.handler;

import com.od.crowdy.user.dto.AuthRequest;
import com.od.crowdy.user.dto.RegisterUserDto;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthHandler {
    private final AuthFacade authFacade;

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(
                        authFacade.login(
                                serverRequest.bodyToMono(AuthRequest.class)
                        ),
                        UserDto.class
                );
    }

    public Mono<ServerResponse> register(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(
                        authFacade.register(
                                serverRequest.bodyToMono(RegisterUserDto.class)
                        ),
                        UserDto.class
                );
    }
}
