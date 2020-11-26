package com.od.crowdy.user.handler;

import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.dto.UserDto;
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
    public final static String PROJECT_ID = "projectId";
    private final UserFacade userFacade;

    public Mono<ServerResponse> getAuthor(ServerRequest serverRequest) {
        return ok()
                .body(
                        userFacade.getAuthor(serverRequest.pathVariable(PROJECT_ID)),
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

    public Mono<ServerResponse> getUserLikesByProjectId(ServerRequest serverRequest) {
        return ok()
                .body(
                        userFacade.getUserLikesByProjectId(serverRequest.pathVariable(PROJECT_ID)),
                        User.class
                );
    }
}
