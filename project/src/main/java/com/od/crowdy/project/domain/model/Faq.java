package com.od.crowdy.project.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("faq")
public class Faq extends com.od.crowdy.shared.domain.model.Faq {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
