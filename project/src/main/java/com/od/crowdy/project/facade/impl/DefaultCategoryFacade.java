package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.Category;
import com.od.crowdy.project.facade.CategoryFacade;
import com.od.crowdy.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultCategoryFacade implements CategoryFacade {
    private final CategoryService categoryService;

    @Override
    public Mono<Category> findCategoryById(String id) {
        return categoryService.findById(id);
    }

    @Override
    public Flux<Category> saveAllCategory(Flux<Category> category) {
        return categoryService.saveAll(category);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return categoryService.deleteById(id);
    }

    @Override
    public Flux<Category> findAllCategory() {
        return categoryService.findAll();
    }
}
