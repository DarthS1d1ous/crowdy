package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryFacade {
    Mono<Category> findCategoryById(String id);

    Flux<Category> saveAllCategory(Flux<Category> category);

    Mono<Void> deleteById(String id);

    Flux<Category> findAllCategory();
}
