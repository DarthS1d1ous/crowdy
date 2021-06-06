package com.od.crowdy.project.service;

import com.od.crowdy.project.domain.neo4j.model.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {
    Flux<Project> getProjectsByCategoryName(String categoryName);

    Mono<Project> saveProjectLike(String userId, String projectId);

    Mono<Void> deleteProjectLike(String userId, String projectId);
}
