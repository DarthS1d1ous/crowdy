package com.od.crowdy.user.handler;

import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
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
    public static final String PROJECT_ID = "projectId";
    public static final String USER_ID = "userId";
    public static final String COMMENT_ID = "commentId";
    private final UserFacade userFacade;

    public Mono<ServerResponse> getAuthorByProjectId(ServerRequest serverRequest) {
        return ok()
            .body(
                userFacade.getAuthorByProjectId(serverRequest.pathVariable(PROJECT_ID)),
                UserDto.class
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
                UserDto.class
            );
    }

    public Mono<ServerResponse> getFollowersByUserId(ServerRequest serverRequest) {
        return ok()
            .body(
                userFacade.getFollowersByUserId(serverRequest.pathVariable(USER_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getAuthorByCommentId(ServerRequest serverRequest) {
        return ok()
            .body(
                userFacade.getAuthorByCommentId(serverRequest.pathVariable(COMMENT_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        return ok()
            .body(
                userFacade.getUserById(serverRequest.pathVariable(USER_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getUserProfileById(ServerRequest serverRequest) {
        return ok()
            .body(
                userFacade.getUserProfileById(serverRequest.pathVariable(USER_ID)),
                UserProfileDto.class
            );
    }
}
