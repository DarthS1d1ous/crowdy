package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.repository.CategoriesRepository;
import com.od.crowdy.project.service.CategoriesService;
import com.od.crowdy.shared.domain.model.Categories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCategoriesService implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public Mono<Categories> save(Categories model) {
        return this.categoriesRepository.save(model);
    }

    @Override
    public Mono<Void> delete(Categories model) {
        return this.categoriesRepository.delete(model);
    }

    @Override
    public Mono<Categories> findById(String id) {
        return this.categoriesRepository.findById(id);
    }

    @Override
    public Flux<Categories> findAll() {
        return this.categoriesRepository.findAll();
    }
}
