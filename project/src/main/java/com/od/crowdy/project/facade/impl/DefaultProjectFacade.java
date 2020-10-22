package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.Project;
import com.od.crowdy.project.facade.ProjectFacade;
import com.od.crowdy.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultProjectFacade implements ProjectFacade {

    private final ProjectService projectService;

    @Override
    public Mono<Project> findProjectById(String projectId) {
        return projectService.findById(projectId);
    }

    @Override
    public Flux<Project> saveAllProjects(Flux<Project> project) {
        return projectService.saveAll(project);
    }

    @Override
    public Mono<Void> deleteById(String projectId) {
        return projectService.deleteById(projectId);
    }

    @Override
    public Flux<Project> findAllProjects() {
        return projectService.findAll();
    }
}
