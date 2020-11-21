package com.od.crowdy.user.dao.neo4j.repository;

import com.od.crowdy.user.dao.UserRepository;
import com.od.crowdy.user.dao.neo4j.model.User;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class Neo4jUserRepository implements UserRepository {
    private final ReactiveNeo4jClient neo4jClient;

    @Override
    public Mono<User> getAuthor(String projectId) {
        return neo4jClient.query(Queries.FIND_AUTHOR_BY_PROJECT_ID_CYPHER)
                .bind(projectId).to("projectId")
                .fetchAs(User.class)
                .mappedBy((typeSystem, record) -> User.mappingFunction(
                        record
                                .values()
                                .stream()
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException(String.format("There is no user owns project with projectId=%s", projectId))
                                )))
                .one();
    }
}
