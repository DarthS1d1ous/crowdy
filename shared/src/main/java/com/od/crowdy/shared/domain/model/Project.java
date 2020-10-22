package com.od.crowdy.shared.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String id;
    private User author;
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
