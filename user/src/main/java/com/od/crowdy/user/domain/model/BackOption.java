package com.od.crowdy.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("back_option")
public class BackOption {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private BigDecimal pledge;
    private String reward;

    @Relationship(type = "WANTS", direction = Relationship.Direction.INCOMING)
    private Set<User> backers;

    @Relationship(type = "ACTIVATES", direction = Relationship.Direction.INCOMING)
    private Set<Payment> payments;
}
