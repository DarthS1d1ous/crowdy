package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.model.Categories;
import com.od.crowdy.project.repository.CategoriesRepository;
import com.od.crowdy.project.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCategoriesService implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public Flux<Categories> saveAll(Flux<Categories> model) {
        return categoriesRepository.saveAll(model);
    }

    @Override
    public Mono<Void> deleteById(String categoriesId) {
        return this.categoriesRepository.deleteById(categoriesId);
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
