package com.od.crowdy.project.dao;

import com.od.crowdy.project.domain.neo4j.model.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectRepository {
    Flux<Project> findProjectsByCategoryName(String categoryName);

    Mono<Project> findProjectById(String projectId);

    Flux<Project> findProjectsByUserId(String userId);
}
