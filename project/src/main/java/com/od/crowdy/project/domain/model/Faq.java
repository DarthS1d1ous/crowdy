package com.od.crowdy.project.domain.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("faq")
@Builder
public class Faq extends com.od.crowdy.shared.domain.model.Faq {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
