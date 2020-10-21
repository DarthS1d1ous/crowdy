package com.od.crowdy.project.repository;

import com.od.crowdy.shared.domain.model.Categories;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends ReactiveMongoRepository<Categories, String> {
}
