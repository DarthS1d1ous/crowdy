package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentFacade {
    Mono<Comment> findCommentById(String id);

    Flux<Comment> saveAllComments(Flux<Comment> comment);

    Mono<Void> deleteById(String id);

    Flux<Comment> findAllComments();
}
