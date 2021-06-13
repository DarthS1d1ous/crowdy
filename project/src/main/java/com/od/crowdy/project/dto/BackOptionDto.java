package com.od.crowdy.project.dto;

import com.od.crowdy.project.domain.neo4j.model.BackOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BackOptionDto {
    private String id;
    private BigDecimal pledge;
    private List<String> rewards;

    public static BackOptionDto from(BackOption backOption) {
        return BackOptionDto.builder()
            .id(backOption.getId())
            .pledge(backOption.getPledge())
            .rewards(backOption.getRewards())
            .build();
    }
}
