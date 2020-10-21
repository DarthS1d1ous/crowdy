package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {
    Mono<Project> save(Mono<Project> project);
}
