package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.dao.neo4j.model.Category;
import com.od.crowdy.project.dao.neo4j.model.Project;
import com.od.crowdy.project.dao.neo4j.model.User;
import com.od.crowdy.project.domain.dto.CategoryDto;
import com.od.crowdy.project.domain.dto.ProjectDto;
import com.od.crowdy.project.domain.dto.UserDto;
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
public class DefaultCategoryFacade implements CategoryFacade {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProjectService projectService;

    @Override
    public Flux<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories()
                .map(Category::toDto)
                .flatMap(this::fillProjects);
    }

    private Flux<CategoryDto> fillProjects(CategoryDto categoryDto) {
        return projectService.getProjects(categoryDto.getName())
                .map(Project::toDto)
                .doOnNext(categoryDto.getProjectDtos()::add)
                .flatMap(this::fillAuthor)
                .thenMany(Flux.just(categoryDto));
    }

    private Mono<UserDto> fillAuthor(ProjectDto projectDto) {
        return userService.getAuthor(projectDto.getId())
                .map(User::toDto)
                .doOnNext(projectDto::setAuthor);
    }
}
