package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.neo4j.model.Comment;
import com.od.crowdy.project.domain.neo4j.repository.CommentRepository;
import com.od.crowdy.project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Flux<Comment> getProjectCommentsByProjectId(String projectId) {
        return this.commentRepository.findCommentsByProjectId(projectId);
    }
}
