package com.od.crowdy.project.repository;

import com.od.crowdy.project.domain.model.Faq;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends ReactiveNeo4jRepository<Faq, String> {
}
