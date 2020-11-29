package com.od.crowdy.project.facade;

import com.od.crowdy.project.dto.ProjectDto;
import reactor.core.publisher.Mono;

public interface ProjectFacade {
    Mono<ProjectDto> getProjectById(String projectId);
}
