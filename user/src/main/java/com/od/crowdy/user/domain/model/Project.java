package com.od.crowdy.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("project")
public class Project {
    @Id
    private String id;
    private String name;
    private List<User> likes;
    private String description;
    private List<Comment> comments;
    private List<Faq> faqs;
    private List<Binary> images;
    private BigDecimal overallBack;
    private BigDecimal currentBack;
    private List<BackOption> backOptions;
    private LocalDate createdAt;
    private LocalDate expiredAt;
    private List<String> categories;
}
