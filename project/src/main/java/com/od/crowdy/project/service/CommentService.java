package com.od.crowdy.project.service;

import com.od.crowdy.project.domain.neo4j.model.Comment;
import reactor.core.publisher.Flux;

public interface CommentService {
    Flux<Comment> getProjectCommentsByProjectId(String projectId);
}
