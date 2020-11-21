package com.od.crowdy.project.dao;

import com.od.crowdy.project.dao.neo4j.model.Category;
import reactor.core.publisher.Flux;

public interface CategoryRepository {
    Flux<Category> findAll();
}
