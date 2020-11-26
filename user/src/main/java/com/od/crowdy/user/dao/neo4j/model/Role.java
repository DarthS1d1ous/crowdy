package com.od.crowdy.user.dao.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.driver.Record;
import org.neo4j.springframework.data.core.schema.Node;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Role")
public class Role {

    @Id
    private String name;

    public static Role mappingFunction(Record record) {
        return Role.builder()
                .name(record.get("name").asString())
                .build();
    }
}
