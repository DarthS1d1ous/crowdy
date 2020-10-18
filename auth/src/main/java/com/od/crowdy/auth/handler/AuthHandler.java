package com.od.crowdy.auth.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class AuthHandler {

    public Mono<ServerResponse> auth(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .bodyValue(Objects.requireNonNull(serverRequest.headers().firstHeader("Authorization")));
    }
}
