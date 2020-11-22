package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.dao.ProjectRepository;
import com.od.crowdy.project.dao.neo4j.model.Project;
import com.od.crowdy.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class DefaultProjectService implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Flux<Project> getProjectsByCategoryName(String categoryName) {
        return this.projectRepository.findProjectsByCategoryName(categoryName);
    }
}
