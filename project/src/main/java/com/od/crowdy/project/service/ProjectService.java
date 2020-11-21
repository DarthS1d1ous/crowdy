package com.od.crowdy.project.service;

import com.od.crowdy.project.dao.neo4j.model.Project;
import reactor.core.publisher.Flux;

public interface ProjectService {
    Flux<Project> getProjects(String categoryName);
}
