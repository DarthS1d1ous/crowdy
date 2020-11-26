package com.od.crowdy.project.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.project.domain.neo4j.model.Project;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProjectMapper implements Neo4jMapper<Project> {
    private final static int PROJECT_INDEX = 0;
    private final static String ID = "id";
    private final static String NAME = "name";
    private final static String DESCRIPTION = "description";
    private final static String CREATED_AT = "createdAt";
    private final static String DEADLINE = "deadline";
    private final static String IMAGE_URLS = "imageUrls";
    private final static String OVERALL_BACK = "overallBack";
    private final static String CURRENT_BACK = "currentBack";

    @Override
    public Project map(Record record) {
        Value project = record.values().get(PROJECT_INDEX);
        return Project.builder()
                .id(project.get(ID).asString())
                .name(project.get(NAME).asString())
                .description(project.get(DESCRIPTION).asString())
                .createdAt(project.get(CREATED_AT).asLocalDate())
                .deadline(project.get(DEADLINE).asLocalDate())
                .imageUrls(project.get(IMAGE_URLS).asList(Value::asString))
                .overallBack(new BigDecimal(project.get(OVERALL_BACK).asString()))
                .currentBack(new BigDecimal(project.get(CURRENT_BACK).asString()))
                .build();
    }
}
