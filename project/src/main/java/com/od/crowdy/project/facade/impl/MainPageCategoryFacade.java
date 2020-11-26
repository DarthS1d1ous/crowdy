package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.neo4j.model.Category;
import com.od.crowdy.project.domain.neo4j.model.Project;
import com.od.crowdy.project.domain.neo4j.model.User;
import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.dto.ProjectDto;
import com.od.crowdy.project.facade.CategoryFacade;
import com.od.crowdy.project.service.CategoryService;
import com.od.crowdy.project.service.ProjectService;
import com.od.crowdy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Log4j2
public class MainPageCategoryFacade implements CategoryFacade {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProjectService projectService;

    @Override
    public Flux<CategoryDto> getAllCategories() {
        return this.categoryService
                .getAllCategories()
                .map(Category::toDto)
                .flatMap(this::fillProjects);
    }

    private Mono<CategoryDto> fillProjects(CategoryDto categoryDto) {
        return this.projectService
                .getProjectsByCategoryName(categoryDto.getName())
                .map(Project::toDto)
                .doOnNext(categoryDto.getProjectDtos()::add)
                .flatMap(this::fillAuthor)
                .flatMap(this::fillLikes)
                .then(Mono.just(categoryDto));
    }

    private Mono<ProjectDto> fillLikes(ProjectDto projectDto) {
        return this.userService
                .getUserLikesByProject(projectDto.getId())
                .map(User::toDto)
                .doOnNext(projectDto.getLikes()::add)
                .then()
                .thenReturn(projectDto);
    }

    private Mono<ProjectDto> fillAuthor(ProjectDto projectDto) {
        return this.userService
                .getAuthorByProjectId(projectDto.getId())
                .map(User::toDto)
                .doOnNext(projectDto::setAuthor)
                .thenReturn(projectDto);
    }
}
