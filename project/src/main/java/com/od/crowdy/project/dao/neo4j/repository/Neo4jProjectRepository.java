package com.od.crowdy.project.dao.neo4j.repository;

import com.od.crowdy.project.dao.ProjectRepository;
import com.od.crowdy.project.dao.neo4j.model.Project;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class Neo4jProjectRepository implements ProjectRepository {
    private final ReactiveNeo4jClient neo4jClient;

    @Override
    public Flux<Project> findProjects(String categoryName) {
        return neo4jClient.query(Queries.FIND_PROJECTS_BY_CATEGORY_NAME_CYPHER)
                .bind(categoryName).to("categoryName")
                .fetchAs(Project.class)
                .mappedBy((typeSystem, record) -> Project.mappingFunction(record))
                .all();
    }
}
