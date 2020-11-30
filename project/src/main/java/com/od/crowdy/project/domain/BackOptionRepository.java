package com.od.crowdy.project.domain;

import com.od.crowdy.project.domain.neo4j.model.BackOption;
import reactor.core.publisher.Flux;

public interface BackOptionRepository {
    Flux<BackOption> findBackOptionsByProjectId(String projectId);
}
