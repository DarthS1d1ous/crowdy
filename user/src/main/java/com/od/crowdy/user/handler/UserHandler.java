package com.od.crowdy.user.handler;

import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.dto.UserProfileDto;
import com.od.crowdy.user.facade.UserFacade;
import com.od.crowdy.user.request.FollowRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
@RequiredArgsConstructor
public class UserHandler {
    public static final String PROJECT_ID = "projectId";
    public static final String USER_ID = "userId";
    public static final String FOLLOWER_ID = "followerId";
    public static final String FOLLOWING_ID = "followingId";
    public static final String COMMENT_ID = "commentId";
    private final UserFacade userFacade;

    public Mono<ServerResponse> getUserLikesByProjectId(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.getUserLikesByProjectId(request.pathVariable(PROJECT_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getAuthorByCommentId(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.getAuthorByCommentId(request.pathVariable(COMMENT_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.getUserById(request.pathVariable(USER_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getAuthorByProjectId(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.getAuthorByProjectId(request.pathVariable(PROJECT_ID)),
                UserDto.class
            );
    }

    public Mono<ServerResponse> getUserProfileByUserId(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.getUserProfileByUserId(request.pathVariable(USER_ID)),
                UserProfileDto.class
            );
    }

    public Mono<ServerResponse> saveUserFollower(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.saveUserFollower(request.bodyToMono(FollowRequest.class)),
                UserProfileDto.class
            );
    }

    public Mono<ServerResponse> deleteUserFollower(ServerRequest request) {
        return ok()
            .body(
                this.userFacade.deleteUserFollower(request.pathVariable(FOLLOWER_ID), request.pathVariable(FOLLOWING_ID)),
                UserProfileDto.class
            );
    }
}
