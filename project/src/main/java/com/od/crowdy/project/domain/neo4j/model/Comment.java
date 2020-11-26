package com.od.crowdy.project.domain.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Comment")
public class Comment {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private LocalDate createdAt;
    private String message;
}
