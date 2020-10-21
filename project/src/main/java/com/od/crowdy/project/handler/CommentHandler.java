package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.Comment;
import com.od.crowdy.project.facade.CommentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CommentHandler {
    private final CommentFacade commentFacade;

    public Mono<ServerResponse> findCommentById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(commentFacade.findCommentById(serverRequest.pathVariable("id")), Comment.class);
    }

    public Mono<ServerResponse> saveComment(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(commentFacade.saveComment(serverRequest.bodyToMono(Comment.class)), Comment.class);
    }

    public Mono<ServerResponse> deleteCommentById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(commentFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllComments(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(commentFacade.findAllComments(), Comment.class);
    }
}
