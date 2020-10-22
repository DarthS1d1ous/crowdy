package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.Comment;
import com.od.crowdy.project.facade.CommentFacade;
import com.od.crowdy.project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultCommentFacade implements CommentFacade {
    private final CommentService commentService;

    @Override
    public Mono<Comment> findCommentById(String id) {
        return commentService.findById(id);
    }

    @Override
    public Flux<Comment> saveAllComments(Flux<Comment> comment) {
        return commentService.saveAll(comment);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return commentService.deleteById(id);
    }

    @Override
    public Flux<Comment> findAllComments() {
        return commentService.findAll();
    }
}
