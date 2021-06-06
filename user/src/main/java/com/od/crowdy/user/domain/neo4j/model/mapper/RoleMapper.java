package com.od.crowdy.user.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.user.domain.neo4j.model.Role;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements Neo4jMapper<Role> {
    private final static int ROLE_INDEX = 0;
    private final static String ID = "id";
    private final static String NAME = "name";

    @Override
    public Role map(Record record) {
        Value role = record.values().get(ROLE_INDEX);
        return Role.builder()
            .id(role.get(ID).asString())
            .name(role.get(NAME).asString())
            .build();
    }
}
