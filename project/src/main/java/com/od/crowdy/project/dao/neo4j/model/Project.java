package com.od.crowdy.project.dao.neo4j.model;

import com.od.crowdy.project.domain.dto.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.driver.Record;
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

    public static Project mappingFunction(Record value) {
        return Project.builder()
                .id(value.get("id").asString())
                .name(value.get("name").asString())
                .description(value.get("description").asString())
                .createdAt(value.get("createdAt").asLocalDate())
                .deadline(value.get("deadline").asLocalDate())
                .imageUrls(value.get("imageUrls").asList(Value::asString))
                .overallBack(new BigDecimal(value.get("overallBack").asString()))
                .currentBack(new BigDecimal(value.get("currentBack").asString()))
                .build();
    }

    public static ProjectDto toDto(Project project) {
        return ProjectDto.from(project);
    }
}
