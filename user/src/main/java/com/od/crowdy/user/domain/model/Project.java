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
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("project")
public class Project implements CurrentBackCalculator {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String name;
    private LocalDate createdAt;
    private LocalDate deadline;
    private List<URL> imagesUrls;
    private ProjectType projectType;


    private BigDecimal overallBack;
    /**
     * Dynamic field
     */
    private BigDecimal currentBack;

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<Comment> comments;

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<Faq> faqs;

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<BackOption> backOptions;

    @Relationship(type = "RELATED_TO", direction = Relationship.Direction.OUTGOING)
    private Set<Category> Category;

    @Relationship(type = "LIKES", direction = Relationship.Direction.INCOMING)
    private List<User> likes;

    @Relationship(type = "PASSED_TO", direction = Relationship.Direction.INCOMING)
    private List<Payment> payments;

    @Override
    public BigDecimal calculateAndGetCurrentBack() {
        // TODO get all payments amount
        return null;
    }
}
