package com.od.crowdy.project.domain.neo4j.repository;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.project.domain.BackOptionRepository;
import com.od.crowdy.project.domain.neo4j.model.BackOption;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class Neo4jBackOptionRepository implements BackOptionRepository {
    private final ReactiveNeo4jClient neo4jClient;
    private final Neo4jMapper<BackOption> backOptionMapper;

    @Override
    public Flux<BackOption> findBackOptionsByProjectId(String projectId) {
        return neo4jClient.query(Queries.FIND_BACKOPTIONS_BY_PROJECT_ID_CYPHER)
            .bind(projectId).to("projectId")
            .fetchAs(BackOption.class)
            .mappedBy((typeSystem, record) -> backOptionMapper.map(record))
            .all();
    }
}
