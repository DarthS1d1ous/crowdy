package com.od.crowdy.project.facade;

import com.od.crowdy.project.dto.BackOptionDto;
import reactor.core.publisher.Flux;

public interface BackOptionFacade {
    Flux<BackOptionDto> getBackOptionsByProjectId(String projectId);
}
