package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
    Mono<Comment> save(Mono<Comment> comment);
}
