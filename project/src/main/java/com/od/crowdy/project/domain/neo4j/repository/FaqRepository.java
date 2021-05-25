package com.od.crowdy.project.domain.neo4j.repository;

import com.od.crowdy.project.domain.neo4j.model.Faq;
import reactor.core.publisher.Flux;

public interface FaqRepository {
    Flux<Faq> findFaqsByProjectId(String projectId);
}
