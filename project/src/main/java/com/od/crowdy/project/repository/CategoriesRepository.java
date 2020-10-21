package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Categories;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoriesRepository extends ReactiveMongoRepository<Categories, String> {
    Mono<Categories> save(Mono<Categories> categories);
}
