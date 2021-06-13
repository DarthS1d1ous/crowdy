package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.neo4j.model.Comment;
import com.od.crowdy.project.domain.neo4j.repository.CommentRepository;
import com.od.crowdy.project.dto.CommentDto;
import com.od.crowdy.project.facade.CommentFacade;
import com.od.crowdy.project.request.CommentSaveRequest;
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

    @Override
    public Mono<CommentDto> updateComment(Mono<CommentDto> commentDto) {
        return commentDto.flatMap(this::convertAndUpdateComment);
    }

    private Mono<CommentDto> convertAndUpdateComment(CommentDto commentDto) {
        Comment comment = Comment.from(commentDto);
        comment.setId(commentDto.getId());
        return commentRepository.update(comment)
            .map(Comment::toDto);
    }

    private Mono<CommentDto> fillCommentAuthor(CommentDto commentDto) {
        return userService.getAuthorByCommentId(commentDto.getId())
            .doOnNext(commentDto::setAuthor)
            .thenReturn(commentDto);
    }
}
