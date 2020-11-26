package com.od.crowdy.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.od.crowdy.project.domain.neo4j.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    @JsonProperty(value = "projects")
    private List<ProjectDto> projectDtos;
    private String id;
    private String name;

    public static CategoryDto from(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public List<ProjectDto> getProjectDtos() {
        if (projectDtos == null) {
            projectDtos = new ArrayList<>();
        }
        return projectDtos;
    }
}
