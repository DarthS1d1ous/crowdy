package com.od.crowdy.project.helper.impl;

import com.od.crowdy.project.domain.neo4j.model.Project;
import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.dto.ProjectDto;
import com.od.crowdy.project.helper.ProjectHelper;
import com.od.crowdy.project.service.ProjectService;
import com.od.crowdy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultProjectHelper implements ProjectHelper {
    private final UserService userService;
    private final ProjectService projectService;

    @Override
    public Mono<CategoryDto> fillProjects(CategoryDto categoryDto) {
        return this.projectService
            .getProjectsByCategoryName(categoryDto.getName())
            .map(Project::toDto)
            .doOnNext(categoryDto.getProjectDtos()::add)
            .flatMap(this::fillAuthor)
            .flatMap(this::fillLikes)
            .then(Mono.just(categoryDto));
    }

    @Override
    public Mono<ProjectDto> fillLikes(ProjectDto projectDto) {
        return this.userService
            .getUserLikesByProject(projectDto.getId())
            .doOnNext(projectDto.getLikes()::add)
            .then()
            .thenReturn(projectDto);
    }

    @Override
    public Mono<ProjectDto> fillAuthor(ProjectDto projectDto) {
        return this.userService
            .getAuthorByProjectId(projectDto.getId())
            .doOnNext(projectDto::setAuthor)
            .thenReturn(projectDto);
    }
}
