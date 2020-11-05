package com.od.crowdy.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Project")
public class Project implements CurrentBackCalculator {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String name;
    private LocalDate createdAt;
    private LocalDate deadline;
    private List<URL> imageUrls;
    private BigDecimal overallBack;
    /**
     * Dynamic field
     */
    private BigDecimal currentBack;
    @Override
    public BigDecimal calculateAndGetCurrentBack() {
        // TODO get all payments amount
        return null;
    }
}
