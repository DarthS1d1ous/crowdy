package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.neo4j.model.Project;
import com.od.crowdy.project.domain.neo4j.repository.ProjectRepository;
import com.od.crowdy.project.dto.ProjectDto;
import com.od.crowdy.project.facade.ProjectFacade;
import com.od.crowdy.project.helper.ProjectHelper;
import com.od.crowdy.project.request.LikeRequest;
import com.od.crowdy.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProjectDetailsProjectFacade implements ProjectFacade {
    private final ProjectRepository projectRepository;
    private final ProjectService projectService;
    private final ProjectHelper projectHelper;

    @Override
    public Mono<ProjectDto> getProjectById(String projectId) {
        return projectRepository.findProjectById(projectId)
            .map(Project::toDto)
            .flatMap(projectHelper::fillAuthor)
            .flatMap(projectHelper::fillLikes);
    }

    @Override
    public Flux<ProjectDto> getProjectByUserId(String userId) {
        return projectRepository.findProjectsByUserId(userId)
            .map(Project::toDto);
    }

    @Override
    public Mono<ProjectDto> saveProjectLike(Mono<LikeRequest> likeRequest) {
        return likeRequest.flatMap(request ->
            this.projectService.saveProjectLike(request.getUserId(), request.getProjectId()))
            .map(ProjectDto::from)
            .flatMap(projectHelper::fillAuthor)
            .flatMap(projectHelper::fillLikes);
    }

    @Override
    public Mono<Void> deleteProjectLike(String userId, String projectId) {
        return this.projectService.deleteProjectLike(userId, projectId);
//            .map(ProjectDto::from)
//            .flatMap(projectHelper::fillAuthor)
//            .flatMap(projectHelper::fillLikes);
    }
}
