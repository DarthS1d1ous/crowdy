package com.od.crowdy.user.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.user.domain.neo4j.model.Role;
import lombok.RequiredArgsConstructor;
import org.neo4j.driver.Record;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapper implements Neo4jMapper<Role> {

    @Override
    public Role map(Record record) {
        return Role.builder()
                .name(record.get("name").asString())
                .build();
    }
}
