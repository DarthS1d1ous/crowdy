package com.od.crowdy.user.service;

import com.od.crowdy.user.dto.ProjectDto;
import reactor.core.publisher.Flux;

public interface ProjectService {
    Flux<ProjectDto> getCreatedProjectsByUserId(String userId);

    Flux<ProjectDto> getBackedProjectsByUserId(String userId);
}
