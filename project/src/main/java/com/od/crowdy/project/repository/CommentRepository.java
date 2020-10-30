package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Comment;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CommentRepository extends ReactiveNeo4jRepository<Comment, String> {
    Mono<Comment> save(Mono<Comment> comment);
}
