package com.od.crowdy.project.handler;

import com.od.crowdy.project.dto.CommentDto;
import com.od.crowdy.project.facade.CommentFacade;
import com.od.crowdy.project.request.CommentSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class CommentHandler {
    private final CommentFacade commentFacade;

    public Mono<ServerResponse> getCommentsByProjectId(ServerRequest serverRequest) {
        return ok()
            .body(
                commentFacade.getCommentsByProjectId(serverRequest.pathVariable(ProjectHandler.PROJECT_ID)),
                CommentDto.class
            );
    }

    public Mono<ServerResponse> saveComment(ServerRequest serverRequest) {
        return ok()
            .body(
                commentFacade.saveComment(serverRequest.bodyToMono(CommentSaveRequest.class)),
                CommentDto.class
            );
    }

    public Mono<ServerResponse> updateComment(ServerRequest serverRequest) {
        return ok()
            .body(
                commentFacade.updateComment(serverRequest.bodyToMono(CommentDto.class)),
                CommentDto.class
            );
    }
}
