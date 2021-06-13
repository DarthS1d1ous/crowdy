package com.od.crowdy.project.helper.impl;

import com.od.crowdy.project.domain.neo4j.model.Project;
import com.od.crowdy.project.dto.*;
import com.od.crowdy.project.helper.CommentHelper;
import com.od.crowdy.project.helper.ProjectHelper;
import com.od.crowdy.project.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultProjectHelper implements ProjectHelper {
    private final UserService userService;
    private final ProjectService projectService;
    private final CommentService commentService;
    private final FaqService faqService;
    private final BackOptionService backOptionService;
    private final CommentHelper commentHelper;

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
    public <T extends ProjectDto> Mono<T> fillLikes(T projectDto) {
        return this.userService
            .getUserLikesByProjectId(projectDto.getId())
            .doOnNext(projectDto.getLikes()::add)
            .then(Mono.just(projectDto));
    }

    @Override
    public <T extends ProjectDto> Mono<T> fillAuthor(T projectDto) {
        return this.userService
            .getAuthorByProjectId(projectDto.getId())
            .doOnNext(projectDto::setAuthor)
            .thenReturn(projectDto);
    }

    @Override
    public Mono<ProjectDetailsDto> fillProjectComments(ProjectDetailsDto projectDto) {
        return this.commentService.getProjectCommentsByProjectId(projectDto.getId())
            .map(CommentDto::from)
            .flatMap(commentHelper::fillCommentAuthor)
            .collectList()
            .doOnNext(projectDto::setComments)
            .thenReturn(projectDto);
    }

    @Override
    public Mono<ProjectDetailsDto> fillProjectFaqs(ProjectDetailsDto projectDto) {
        return this.faqService.getProjectFaqsByProjectId(projectDto.getId())
            .map(FaqDto::from)
            .collectList()
            .doOnNext(projectDto::setFaqs)
            .thenReturn(projectDto);
    }

    @Override
    public Mono<ProjectDetailsDto> fillProjectBackOptions(ProjectDetailsDto projectDto) {
        return this.backOptionService.getProjectBackOptionsByProjectId(projectDto.getId())
            .map(BackOptionDto::from)
            .collectList()
            .doOnNext(projectDto::setBackOptions)
            .thenReturn(projectDto);
    }
}
