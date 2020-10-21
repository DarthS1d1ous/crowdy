package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.Categories;
import com.od.crowdy.project.facade.CategoriesFacade;
import com.od.crowdy.project.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultCategoriesFacade implements CategoriesFacade {
    private final CategoriesService categoriesService;

    @Override
    public Mono<Categories> findCategoryById(String id) {
        return categoriesService.findById(id);
    }

    @Override
    public Mono<Categories> saveCategory(Mono<Categories> category) {
        return categoriesService.save(category);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return categoriesService.deleteById(id);
    }

    @Override
    public Flux<Categories> findAllCategories() {
        return categoriesService.findAll();
    }
}
