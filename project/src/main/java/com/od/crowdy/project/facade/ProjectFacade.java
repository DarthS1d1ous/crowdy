package com.od.crowdy.project.facade;

import com.od.crowdy.project.dto.ProjectDto;
import com.od.crowdy.project.request.LikeRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectFacade {
    Mono<ProjectDto> getProjectById(String projectId);

    Flux<ProjectDto> getProjectByUserId(String userId);

    Mono<ProjectDto> saveProjectLike(Mono<LikeRequest> likeRequest);

    Mono<Void> deleteProjectLike(String userId, String projectId);
}
