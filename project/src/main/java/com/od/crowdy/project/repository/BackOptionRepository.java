package com.od.crowdy.project.repository;

import com.od.crowdy.shared.domain.model.BackOption;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackOptionRepository extends ReactiveMongoRepository<BackOption, String> {
}
