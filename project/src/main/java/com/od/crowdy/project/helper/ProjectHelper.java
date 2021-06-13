package com.od.crowdy.project.helper;

import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.dto.ProjectDetailsDto;
import com.od.crowdy.project.dto.ProjectDto;
import reactor.core.publisher.Mono;

public interface ProjectHelper {
    Mono<CategoryDto> fillProjects(CategoryDto categoryDto);

    <T extends ProjectDto> Mono<T> fillLikes(T projectDto);

    <T extends ProjectDto> Mono<T> fillAuthor(T projectDto);

    Mono<ProjectDetailsDto> fillProjectComments(ProjectDetailsDto projectDto);

    Mono<ProjectDetailsDto> fillProjectFaqs(ProjectDetailsDto projectDto);

    Mono<ProjectDetailsDto> fillProjectBackOptions(ProjectDetailsDto projectDto);


}
