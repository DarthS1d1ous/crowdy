package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Category;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveNeo4jRepository<Category, String> {
    Mono<Category> save(Mono<Category> Category);
}
