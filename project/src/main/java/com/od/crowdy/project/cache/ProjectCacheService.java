package com.od.crowdy.project.cache;

import com.od.crowdy.project.dto.ProjectDetailsDto;
import reactor.core.publisher.Mono;

public interface ProjectCacheService {
    Mono<ProjectDetailsDto> getProjectDetailsByProjectId(String projectId);
}
