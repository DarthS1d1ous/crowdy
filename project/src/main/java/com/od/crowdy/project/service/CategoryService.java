package com.od.crowdy.project.service;

import com.od.crowdy.project.dao.neo4j.model.Category;
import reactor.core.publisher.Flux;

public interface CategoryService {
    Flux<Category> getAllCategories();

}
