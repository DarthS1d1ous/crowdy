package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.BackOption;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BackOptionRepository extends ReactiveNeo4jRepository<BackOption, String> {
    Mono<BackOption> save(Mono<BackOption> backOption);
}
