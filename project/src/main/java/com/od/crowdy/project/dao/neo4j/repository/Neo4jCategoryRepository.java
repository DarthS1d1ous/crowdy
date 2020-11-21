package com.od.crowdy.project.dao.neo4j.repository;

import com.od.crowdy.project.dao.CategoryRepository;
import com.od.crowdy.project.dao.neo4j.model.Category;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class Neo4jCategoryRepository implements CategoryRepository {
    private final ReactiveNeo4jTemplate neo4jTemplate;

    @Override
    public Flux<Category> findAll() {
        return neo4jTemplate.findAll(Category.class);
    }
}
