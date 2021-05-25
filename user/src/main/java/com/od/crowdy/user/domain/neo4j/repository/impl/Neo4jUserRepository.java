package com.od.crowdy.user.domain.neo4j.repository.impl;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.user.domain.neo4j.model.Role;
import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.domain.neo4j.repository.RoleRepository;
import com.od.crowdy.user.domain.neo4j.repository.UserRepository;
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
    private final RoleRepository roleRepository;

    @Override
    public Mono<User> getAuthorByProjectId(String projectId) {
        return neo4jClient.query(Queries.FIND_AUTHOR_BY_PROJECT_ID_CYPHER)
            .bind(projectId).to("projectId")
            .fetchAs(User.class)
            .mappedBy((typeSystem, record) -> userMapper.map(record))
            .one();
    }

    @Override
    public Mono<User> save(User user) {
        return neo4jOperations.save(user)
            .flatMap(u -> roleRepository.save(u.getId(), Role.ADMIN)
                .thenReturn(u)
            );
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
    public Mono<Boolean> isUserExists(String username) {
        return neo4jClient.query(Queries.IS_USER_EXISTS_CYPHER)
            .bind(username).to("username")
            .fetchAs(Boolean.class)
            .mappedBy((typeSystem, record) -> record.get("isExists").asBoolean())
            .one()
            .switchIfEmpty(Mono.just(false));
    }

    @Override
    public Flux<User> getUserLikesByProjectId(String projectId) {
        return neo4jClient.query(Queries.FIND_USER_LIKES_BY_PROJECT_ID_CYPHER)
            .bind(projectId).to("projectId")
            .fetchAs(User.class)
            .mappedBy((typeSystem, record) -> userMapper.map(record))
            .all();
    }

    @Override
    public Flux<User> findFollowersByUserId(String userId) {
        return neo4jClient.query(Queries.FIND_FOLLOWERS_BY_USER_ID_CYPHER)
            .bind(userId).to("userId")
            .fetchAs(User.class)
            .mappedBy((typeSystem, record) -> userMapper.map(record))
            .all();
    }

    @Override
    public Flux<User> findFollowingByUserId(String userId) {
        return neo4jClient.query(Queries.FIND_FOLLOWING_BY_USER_ID_CYPHER)
            .bind(userId).to("userId")
            .fetchAs(User.class)
            .mappedBy((typeSystem, record) -> userMapper.map(record))
            .all();
    }

    @Override
    public Mono<User> findAuthorByCommentId(String commentId) {
        return neo4jClient.query(Queries.FIND_AUTHOR_BY_COMMENT_ID_CYPHER)
            .bind(commentId).to("commentId")
            .fetchAs(User.class)
            .mappedBy(((typeSystem, record) -> userMapper.map(record)))
            .one();
    }

    @Override
    public Mono<User> getUserById(String userId) {
        return neo4jOperations.findById(userId, User.class);
    }
}
