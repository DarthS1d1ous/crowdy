package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Project;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProjectRepository extends ReactiveNeo4jRepository<Project, String> {
    Mono<Project> save(Mono<Project> project);
}
