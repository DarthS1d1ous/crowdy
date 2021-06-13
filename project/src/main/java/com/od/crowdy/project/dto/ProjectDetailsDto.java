package com.od.crowdy.project.dto;

import com.od.crowdy.project.domain.neo4j.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDetailsDto extends ProjectDto {

    private List<CommentDto> comments;
    private List<FaqDto> faqs;
    private List<BackOptionDto> backOptions;


    public static ProjectDetailsDto from(Project project) {
        return ProjectDetailsDto.builder()
            .id(project.getId())
            .name(project.getName())
            .description(project.getDescription())
            .createdAt(project.getCreatedAt())
            .deadline(project.getDeadline())
            .imageUrls(project.getImageUrls())
            .overallBack(project.getOverallBack())
            .currentBack(project.getCurrentBack())
            .build();
    }
}
