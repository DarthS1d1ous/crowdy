package com.od.crowdy.shared.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categories {
    @Id
    private String id;

    private List<String> categories;
}
