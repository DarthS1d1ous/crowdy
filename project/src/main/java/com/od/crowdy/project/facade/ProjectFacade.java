package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectFacade {
    Mono<Project> findProjectById(String projectId);

    Flux<Project> saveAllProjects(Flux<Project> project);

    Mono<Void> deleteById(String projectId);

    Flux<Project> findAllProjects();
}
