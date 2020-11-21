package com.od.crowdy.project.dao;

import com.od.crowdy.project.dao.neo4j.model.Project;
import reactor.core.publisher.Flux;

public interface ProjectRepository {
    Flux<Project> findProjects(String categoryName);
}
