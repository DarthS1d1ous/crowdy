package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.model.Comment;
import com.od.crowdy.project.repository.CommentRepository;
import com.od.crowdy.project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCommentService implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Flux<Comment> saveAll(Flux<Comment> model) {
        return commentRepository.saveAll(model);
    }

    @Override
    public Mono<Void> deleteById(String commentId) {
        return this.commentRepository.deleteById(commentId);
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
