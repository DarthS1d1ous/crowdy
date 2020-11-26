package com.od.crowdy.user.domain.neo4j.repository;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.user.dao.UserRepository;
import com.od.crowdy.user.domain.neo4j.model.User;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.neo4j.springframework.data.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class Neo4jUserRepository implements UserRepository {
    private final ReactiveNeo4jClient neo4jClient;
    private final ReactiveNeo4jOperations neo4jOperations;
    private final Neo4jMapper<User> userMapper;

    @Override
    public Mono<User> getAuthor(String projectId) {
        return neo4jClient.query(Queries.FIND_AUTHOR_BY_PROJECT_ID_CYPHER)
                .bind(projectId).to("projectId")
                .fetchAs(User.class)
                .mappedBy((typeSystem, record) -> userMapper.map(record))
                .one();
    }

    @Override
    public Mono<User> save(User user) {
        return neo4jOperations.save(user);
    }

    @Override
    public Mono<User> findByUsername(String username) {
        return neo4jClient.query(Queries.FIND_USER_BY_USERNAME_CYPHER)
                .bind(username).to("username")
                .fetchAs(User.class)
                .mappedBy((typeSystem, record) -> userMapper.map(record))
                .one();
    }

    @Override
    public Flux<User> getUserLikesByProjectId(String projectId) {
        return neo4jClient.query(Queries.FIND_USER_LIKES_BY_PROJECT_ID_CYPHER)
                .bind(projectId).to("projectId")
                .fetchAs(User.class)
                .mappedBy((typeSystem, record) -> userMapper.map(record))
                .all();
    }
}
