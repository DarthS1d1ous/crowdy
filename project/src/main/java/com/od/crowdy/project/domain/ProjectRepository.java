package com.od.crowdy.project.domain;

import com.od.crowdy.project.domain.neo4j.model.Project;
import reactor.core.publisher.Flux;

public interface ProjectRepository {
    Flux<Project> findProjectsByCategoryName(String categoryName);
}
