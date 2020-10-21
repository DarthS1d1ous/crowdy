package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.BackOption;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BackOptionRepository extends ReactiveMongoRepository<BackOption, String> {
    Mono<BackOption> save(Mono<BackOption> backOption);
}
