package com.od.crowdy.project.domain.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("project")
@Builder
public class Project extends com.od.crowdy.shared.domain.model.Project {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
