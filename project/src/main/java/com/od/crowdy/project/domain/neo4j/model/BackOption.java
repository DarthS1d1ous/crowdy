package com.od.crowdy.project.domain.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("BackOption")
public class BackOption {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private BigDecimal pledge;
    private String reward;
}
