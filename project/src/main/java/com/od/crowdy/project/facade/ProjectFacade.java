package com.od.crowdy.project.facade;

import com.od.crowdy.shared.domain.model.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectFacade {
    Mono<Project> findProjectById(String id);

    Flux<Project> saveAllProjects(Flux<Project> projects);
}
