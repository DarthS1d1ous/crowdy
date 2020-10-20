package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.repository.CommentRepository;
import com.od.crowdy.project.service.CommentService;
import com.od.crowdy.shared.domain.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCommentService implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Mono<Comment> save(Comment model) {
        return this.commentRepository.save(model);
    }

    @Override
    public Mono<Void> delete(Comment model) {
        return this.commentRepository.delete(model);
    }

    @Override
    public Mono<Comment> findById(String id) {
        return this.commentRepository.findById(id);
    }

    @Override
    public Flux<Comment> findAll() {
        return this.commentRepository.findAll();
    }
}
