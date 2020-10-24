package com.od.crowdy.user.handler;

import com.od.crowdy.user.domain.model.User;
import com.od.crowdy.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class UserHandler {
    private final UserFacade userFacade;

    public Mono<ServerResponse> findAllUsers(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(userFacade.findAllUsers(), User.class);

    }

    public Mono<ServerResponse> findUserById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(userFacade.findUserById(serverRequest.pathVariable("id")), User.class);

    }

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(userFacade.saveAllUsers(serverRequest.bodyToFlux(User.class)), User.class);
    }

    public Mono<ServerResponse> deleteUserById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(userFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }
}
