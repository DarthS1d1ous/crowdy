package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Faq;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends ReactiveMongoRepository<Faq, String> {
}
