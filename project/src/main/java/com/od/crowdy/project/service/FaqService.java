package com.od.crowdy.project.service;

import com.od.crowdy.project.domain.neo4j.model.Faq;
import reactor.core.publisher.Flux;

public interface FaqService {
    Flux<Faq> getProjectFaqsByProjectId(String projectId);
}
