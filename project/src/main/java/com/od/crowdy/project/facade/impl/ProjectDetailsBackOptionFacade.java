package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.BackOptionRepository;
import com.od.crowdy.project.domain.neo4j.model.BackOption;
import com.od.crowdy.project.dto.BackOptionDto;
import com.od.crowdy.project.facade.BackOptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ProjectDetailsBackOptionFacade implements BackOptionFacade {
    private final BackOptionRepository backOptionRepository;

    @Override
    public Flux<BackOptionDto> getBackOptionsByProjectId(String projectId) {
        return backOptionRepository.findBackOptionsByProjectId(projectId)
            .map(BackOption::toDto);
    }
}
