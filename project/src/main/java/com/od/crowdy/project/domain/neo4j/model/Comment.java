package com.od.crowdy.project.domain.neo4j.model;

import com.od.crowdy.project.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Comment")
public class Comment {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private LocalDateTime createdAt;
    private String message;

    public static CommentDto toDto(Comment comment) {
        return CommentDto.from(comment);
    }

    public static Comment from(CommentDto commentDto) {
        return Comment.builder()
            .createdAt(commentDto.getCreatedAt())
            .message(commentDto.getMessage())
            .build();
    }
}
