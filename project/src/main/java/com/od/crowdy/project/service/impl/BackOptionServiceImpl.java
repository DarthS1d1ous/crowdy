package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.neo4j.model.BackOption;
import com.od.crowdy.project.domain.neo4j.repository.BackOptionRepository;
import com.od.crowdy.project.service.BackOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BackOptionServiceImpl implements BackOptionService {
    private final BackOptionRepository backOptionRepository;

    @Override
    public Flux<BackOption> getProjectBackOptionsByProjectId(String projectId) {
        return backOptionRepository.findBackOptionsByProjectId(projectId);
    }
}
