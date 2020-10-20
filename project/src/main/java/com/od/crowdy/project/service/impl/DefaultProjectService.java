package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.repository.ProjectRepository;
import com.od.crowdy.project.service.ProjectService;
import com.od.crowdy.shared.domain.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultProjectService implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Mono<Project> save(Project model) {
        return this.projectRepository.save(model);
    }

    @Override
    public Mono<Void> delete(Project model) {
        return this.projectRepository.delete(model);
    }

    @Override
    public Mono<Project> findById(String id) {
        return this.projectRepository.findById(id);
    }

    @Override
    public Flux<Project> findAll() {
        return this.projectRepository.findAll();
    }

}
