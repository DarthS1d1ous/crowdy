package com.od.crowdy.user.domain.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.driver.Value;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Project")
public class Project {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate deadline;
    private List<String> imageUrls;
    private BigDecimal overallBack;
    private BigDecimal currentBack;

    public static Project mappingFunction(Value value) {
        return Project.builder()
                .id(value.get("id").asString())
                .name(value.get("name").asString())
                .description(value.get("description").asString())
                .createdAt(value.get("createdAt").asLocalDate())
                .deadline(value.get("deadline").asLocalDate())
                .imageUrls(value.get("imageUrls").asList(Value::asString))
                .overallBack(BigDecimal.valueOf(value.get("overallBack").asDouble()))
                .build();
    }
}
