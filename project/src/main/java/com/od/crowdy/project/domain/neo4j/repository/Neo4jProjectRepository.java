package com.od.crowdy.project.domain.neo4j.repository;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.project.domain.ProjectRepository;
import com.od.crowdy.project.domain.neo4j.model.Project;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.neo4j.springframework.data.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class Neo4jProjectRepository implements ProjectRepository {
    private final ReactiveNeo4jClient neo4jClient;
    private final ReactiveNeo4jOperations neo4jOperations;
    private final Neo4jMapper<Project> mapper;

    @Override
    public Flux<Project> findProjectsByCategoryName(String categoryName) {
        return this.neo4jClient.query(Queries.FIND_PROJECTS_BY_CATEGORY_NAME_CYPHER)
            .bind(categoryName).to("categoryName")
            .fetchAs(Project.class)
            .mappedBy((typeSystem, record) -> mapper.map(record))
            .all();
    }

    @Override
    public Mono<Project> findProjectById(String projectId) {
        return this.neo4jOperations.findById(projectId, Project.class);
    }

    @Override
    public Flux<Project> findProjectsByUserId(String userId) {
        return this.neo4jClient.query(Queries.FIND_PROJECTS_BY_USER_ID_CYPHER)
            .bind(userId).to("userId")
            .fetchAs(Project.class)
            .mappedBy((typeSystem, record) -> mapper.map(record))
            .all();
    }
}
