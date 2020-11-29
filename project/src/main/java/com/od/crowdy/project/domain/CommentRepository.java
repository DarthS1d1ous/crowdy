package com.od.crowdy.project.domain;

import com.od.crowdy.project.domain.neo4j.model.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentRepository {
    Flux<Comment> findCommentsByProjectId(String projectId);

    Mono<Comment> save(Comment comment, String projectId, String authorID);
}
