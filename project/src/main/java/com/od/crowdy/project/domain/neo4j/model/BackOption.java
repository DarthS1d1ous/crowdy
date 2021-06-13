package com.od.crowdy.project.domain.neo4j.model;

import com.od.crowdy.project.dto.BackOptionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("BackOption")
public class BackOption {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private BigDecimal pledge;
    private List<String> rewards;

    public static BackOptionDto toDto(BackOption backOption) {
        return BackOptionDto.from(backOption);
    }
}
