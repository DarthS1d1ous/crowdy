package com.od.crowdy.project.domain.neo4j.repository.impl;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.common.domain.neo4j.repository.Queries;
import com.od.crowdy.project.domain.neo4j.model.Comment;
import com.od.crowdy.project.domain.neo4j.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.neo4j.springframework.data.core.ReactiveNeo4jClient;
import org.neo4j.springframework.data.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class Neo4jCommentRepository implements CommentRepository {
    private final ReactiveNeo4jClient neo4jClient;
    private final ReactiveNeo4jOperations neo4jOperations;
    private final Neo4jMapper<Comment> commentMapper;

    @Override
    public Flux<Comment> findCommentsByProjectId(String projectId) {
        return neo4jClient.query(Queries.FIND_COMMENTS_BY_PROJECT_ID_CYPHER)
            .bind(projectId).to("projectId")
            .fetchAs(Comment.class)
            .mappedBy((typeSystem, record) -> commentMapper.map(record))
            .all();
    }

    @Override
    public Mono<Comment> save(Comment comment, String projectId, String authorID) {
        return neo4jOperations.save(comment)
            .flatMap(c -> neo4jClient.query(Queries.SAVE_COMMENT_CYPHER)
                .bind(c.getId()).to("commentId")
                .bind(projectId).to("projectId")
                .bind(authorID).to("authorId")
                .fetchAs(Comment.class)
                .mappedBy((typeSystem, record) -> commentMapper.map(record))
                .one()
            );
    }

    @Override
    public Mono<Comment> update(Comment comment) {
        return neo4jOperations.save(comment);
    }

}
