package com.od.crowdy.project.helper;

import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.dto.ProjectDto;
import reactor.core.publisher.Mono;

public interface ProjectHelper {
    Mono<CategoryDto> fillProjects(CategoryDto categoryDto);

    Mono<ProjectDto> fillLikes(ProjectDto projectDto);

    Mono<ProjectDto> fillAuthor(ProjectDto projectDto);
}
