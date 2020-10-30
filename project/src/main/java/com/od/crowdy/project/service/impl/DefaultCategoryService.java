package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.model.Category;
import com.od.crowdy.project.repository.CategoryRepository;
import com.od.crowdy.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {

    private final CategoryRepository CategoryRepository;

    @Override
    public Flux<Category> saveAll(Flux<Category> model) {
        return CategoryRepository.saveAll(model);
    }

    @Override
    public Mono<Void> deleteById(String CategoryId) {
        return this.CategoryRepository.deleteById(CategoryId);
    }

    @Override
    public Mono<Category> findById(String id) {
        return this.CategoryRepository.findById(id);
    }

    @Override
    public Flux<Category> findAll() {
        return this.CategoryRepository.findAll();
    }
}
