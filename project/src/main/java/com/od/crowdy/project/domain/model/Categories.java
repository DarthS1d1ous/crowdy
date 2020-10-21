package com.od.crowdy.project.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
public class Categories extends com.od.crowdy.shared.domain.model.Categories {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
