package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.model.Project;
import com.od.crowdy.project.repository.ProjectRepository;
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
    public Flux<Project> saveAll(Flux<Project> model) {
        return projectRepository.saveAll(model);
    }

    @Override
    public Mono<Void> deleteById(String projectId) {
        return this.projectRepository.deleteById(projectId);
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
