package com.od.crowdy.project.domain;

import com.od.crowdy.project.domain.neo4j.model.Category;
import reactor.core.publisher.Flux;

public interface CategoryRepository {
    Flux<Category> findAll();
}
