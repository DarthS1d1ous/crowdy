package com.od.crowdy.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentSaveRequest {
    private String comment;
    private String projectId;
    private String authorId;
}
