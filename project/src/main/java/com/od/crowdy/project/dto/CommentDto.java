package com.od.crowdy.project.dto;

import com.od.crowdy.project.domain.neo4j.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    private String id;
    private LocalDateTime createdAt;
    private String message;
    private UserDto author;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
            .id(comment.getId())
            .createdAt(comment.getCreatedAt())
            .message(comment.getMessage())
            .build();
    }
}
