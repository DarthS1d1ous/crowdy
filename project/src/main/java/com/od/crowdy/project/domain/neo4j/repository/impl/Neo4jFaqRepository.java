package com.od.crowdy.project.domain.neo4j.repository.impl;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.project.domain.neo4j.model.Faq;
import com.od.crowdy.project.domain.neo4j.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class Neo4jFaqRepository implements FaqRepository {
    private final ReactiveNeo4jClient neo4jClient;
    private final Neo4jMapper<Faq> faqMapper;

    @Override
    public Flux<Faq> findFaqsByProjectId(String projectId) {
        return neo4jClient.query(Queries.FIND_FAQS_BY_PROJECT_ID_CYPHER)
            .bind(projectId).to("projectId")
            .fetchAs(Faq.class)
            .mappedBy((typeSystem, record) -> faqMapper.map(record))
            .all();
    }
}
