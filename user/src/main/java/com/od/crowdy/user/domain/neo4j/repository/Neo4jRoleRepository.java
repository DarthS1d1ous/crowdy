package com.od.crowdy.user.domain.neo4j.repository;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.user.domain.neo4j.RoleRepository;
import com.od.crowdy.user.domain.neo4j.model.Role;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

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
}
