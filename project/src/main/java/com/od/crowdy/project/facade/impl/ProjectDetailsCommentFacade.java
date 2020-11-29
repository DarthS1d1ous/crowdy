package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.CommentRepository;
import com.od.crowdy.project.domain.neo4j.model.Comment;
import com.od.crowdy.project.dto.CommentDto;
import com.od.crowdy.project.dto.CommentSaveRequest;
import com.od.crowdy.project.facade.CommentFacade;
import com.od.crowdy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ProjectDetailsCommentFacade implements CommentFacade {
    private final UserService userService;
    private final CommentRepository commentRepository;

    @Override
    public Flux<CommentDto> getCommentsByProjectId(String projectId) {
        return commentRepository.findCommentsByProjectId(projectId)
            .map(Comment::toDto)
            .flatMap(this::fillCommentAuthor);
    }

    @Override
    public Mono<CommentDto> saveComment(Mono<CommentSaveRequest> commentSaveRequest) {
        return commentSaveRequest.flatMap(commentSave -> userService.getUserById(commentSave.getAuthorId())
            .flatMap(userDto -> commentRepository.save(
                Comment.builder()
                    .message(commentSave.getComment())
                    .createdAt(LocalDateTime.now())
                    .build(), commentSave.getProjectId(), commentSave.getAuthorId()
                )
                    .map(Comment::toDto)
                    .doOnNext(commentDto -> commentDto.setAuthor(userDto))
            )
        );
    }

    private Mono<CommentDto> fillCommentAuthor(CommentDto commentDto) {
        return userService.getAuthorByCommentId(commentDto.getId())
            .doOnNext(commentDto::setAuthor)
            .thenReturn(commentDto);
    }
}