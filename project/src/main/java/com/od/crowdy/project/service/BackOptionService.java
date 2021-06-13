package com.od.crowdy.project.service;

import com.od.crowdy.project.domain.neo4j.model.BackOption;
import reactor.core.publisher.Flux;

public interface BackOptionService {
    Flux<BackOption> getProjectBackOptionsByProjectId(String projectId);
}
