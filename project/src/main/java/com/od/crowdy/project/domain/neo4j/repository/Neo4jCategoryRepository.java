package com.od.crowdy.project.domain.neo4j.repository;

import com.od.crowdy.project.domain.CategoryRepository;
import com.od.crowdy.project.domain.neo4j.model.Category;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class Neo4jCategoryRepository implements CategoryRepository {
    private final ReactiveNeo4jOperations neo4jOperations;

    @Override
    public Flux<Category> findAll() {
        return this.neo4jOperations.findAll(Category.class);
    }
}
