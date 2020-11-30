package com.od.crowdy.user.service;

import com.od.crowdy.user.dto.ProjectDto;
import reactor.core.publisher.Flux;

public interface ProjectService {
    Flux<ProjectDto> getProjectsByUserId(String userId);
}
