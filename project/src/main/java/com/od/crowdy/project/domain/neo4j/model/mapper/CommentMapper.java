package com.od.crowdy.project.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.project.domain.neo4j.model.Comment;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper implements Neo4jMapper<Comment> {
    private final static int COMMENT_INDEX = 0;
    private final static String ID = "id";
    private final static String CREATED_AT = "createdAt";
    private final static String MESSAGE = "message";

    @Override
    public Comment map(Record record) {
        Value comment = record.values().get(COMMENT_INDEX);
        return Comment.builder()
            .id(comment.get(ID).asString())
            .message(comment.get(MESSAGE).asString())
            .createdAt(comment.get(CREATED_AT).asLocalDateTime())
            .build();
    }
}
