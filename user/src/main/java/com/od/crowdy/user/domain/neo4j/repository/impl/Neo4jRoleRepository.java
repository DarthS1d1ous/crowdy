package com.od.crowdy.user.domain.neo4j.repository.impl;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.user.domain.neo4j.model.Role;
import com.od.crowdy.user.domain.neo4j.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class Neo4jRoleRepository implements RoleRepository {
    private final ReactiveNeo4jClient neo4jClient;
    private final Neo4jMapper<Role> roleNeo4jMapper;

    @Override
    public Flux<Role> getRolesByUserId(String userId) {
        return neo4jClient.query(Queries.FIND_ROLES_BY_USER_ID_CYPHER)
            .bind(userId).to("userId")
            .fetchAs(Role.class)
            .mappedBy((typeSystem, record) -> roleNeo4jMapper.map(record))
            .all();
    }

    @Override
    public Mono<Role> save(String userId, String roleName) {
        return neo4jClient.query(Queries.SAVE_ROLE_BY_USER_ID_CYPHER)
            .bind(roleName).to("roleName")
            .bind(userId).to("userId")
            .fetchAs(Role.class)
            .mappedBy((typeSystem, record) -> roleNeo4jMapper.map(record))
            .one();
    }
}
