package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.facade.ProjectFacade;
import com.od.crowdy.project.service.ProjectService;
import com.od.crowdy.shared.domain.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultProjectFacade implements ProjectFacade {

    private final ProjectService projectService;

    @Override
    public Mono<Project> findProjectById(String id) {
        return projectService.findById(id);
    }

    @Override
    public Flux<Project> saveAllProjects(Flux<Project> projects) {
        return projectService.saveAll(projects);
    }
}
