package com.od.crowdy.project.service;

import com.od.crowdy.project.domain.neo4j.model.Project;
import reactor.core.publisher.Flux;

public interface ProjectService {
    Flux<Project> getProjectsByCategoryName(String categoryName);
}
