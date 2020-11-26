package com.od.crowdy.user.handler;

import com.od.crowdy.user.dao.neo4j.model.User;
import com.od.crowdy.user.domain.dto.UserDto;
import com.od.crowdy.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class UserHandler {
    private final UserFacade userFacade;

    public Mono<ServerResponse> getAuthor(ServerRequest serverRequest) {
        return ok()
                .body(
                        userFacade.getAuthor(serverRequest.pathVariable("projectId")),
                        User.class
                );
    }

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        return created(URI.create("/users"))
                .body(
                        userFacade.save(serverRequest.bodyToMono(UserDto.class)),
                        UserDto.class
                );
    }
}
