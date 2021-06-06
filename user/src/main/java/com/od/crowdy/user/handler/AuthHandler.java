package com.od.crowdy.user.handler;

import com.od.crowdy.user.dto.RegisterUserDto;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.facade.AuthFacade;
import com.od.crowdy.user.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class AuthHandler {
    private final AuthFacade authFacade;

    public Mono<ServerResponse> login(ServerRequest request) {
        return ok()
            .body(
                this.authFacade.login(request.bodyToMono(AuthRequest.class)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> register(ServerRequest request) {
        return ok()
            .body(
                this.authFacade.register(request.bodyToMono(RegisterUserDto.class)),
                UserDto.class
            );
    }
}
