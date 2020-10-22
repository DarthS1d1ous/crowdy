package com.od.crowdy.project.domain.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@Builder
public class Categories extends com.od.crowdy.shared.domain.model.Categories {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
