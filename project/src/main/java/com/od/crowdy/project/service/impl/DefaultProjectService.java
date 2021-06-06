package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.neo4j.model.Project;
import com.od.crowdy.project.domain.neo4j.repository.ProjectRepository;
import com.od.crowdy.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultProjectService implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Flux<Project> getProjectsByCategoryName(String categoryName) {
        return this.projectRepository.findProjectsByCategoryName(categoryName);
    }

    @Override
    public Mono<Project> saveProjectLike(String userId, String projectId) {
        return this.projectRepository.saveProjectLike(userId, projectId);
    }

    @Override
    public Mono<Void> deleteProjectLike(String userId, String projectId) {
        return this.projectRepository.deleteProjectLike(userId, projectId);
    }
}
