package com.od.crowdy.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.od.crowdy.user.domain.neo4j.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDto {
    private String id;

    private String name;
    private String description;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate createdAt;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate deadline;
    private List<String> imageUrls;
    private BigDecimal overallBack;
    /**
     * Dynamic field
     */
    private BigDecimal currentBack;

    private UserDto author;

    @JsonProperty(value = "likes")
    private List<UserDto> likes;

    public static ProjectDto from(Project project) {
        return ProjectDto.builder()
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

    public List<UserDto> getLikes() {
        if (likes == null) {
            likes = new ArrayList<>();
        }
        return likes;
    }
}
