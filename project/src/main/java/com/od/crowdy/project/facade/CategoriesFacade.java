package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.Categories;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoriesFacade {
    Mono<Categories> findCategoryById(String id);

    Flux<Categories> saveAllCategories(Flux<Categories> category);

    Mono<Void> deleteById(String id);

    Flux<Categories> findAllCategories();
}
