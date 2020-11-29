package com.od.crowdy.project.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.project.domain.neo4j.model.Faq;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

@Component
public class FaqMapper implements Neo4jMapper<Faq> {
    private final static int FAQ_INDEX = 0;
    private final static String ID = "id";
    private final static String QUESTION = "question";
    private final static String ANSWER = "answer";

    @Override
    public Faq map(Record record) {
        Value faq = record.values().get(FAQ_INDEX);
        return Faq.builder()
            .id(faq.get(ID).asString())
            .question(faq.get(QUESTION).asString())
            .answer(faq.get(ANSWER).asString())
            .build();
    }
}
