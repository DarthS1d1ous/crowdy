package com.od.crowdy.project.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.project.domain.neo4j.model.BackOption;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BackOptionMapper implements Neo4jMapper<BackOption> {
    private final static int BACKOPTION_INDEX = 0;
    private final static String ID = "id";
    private final static String PLEDGE = "pledge";
    private final static String REWARDS = "rewards";

    @Override
    public BackOption map(Record record) {
        Value backOption = record.values().get(BACKOPTION_INDEX);

        return BackOption.builder()
            .id(backOption.get(ID).asString())
            .pledge(BigDecimal.valueOf(backOption.get(PLEDGE).asDouble()))
            .rewards(backOption.get(REWARDS) == null ? null : backOption.get(REWARDS).asList(Value::asString))
            .build();
    }
}
