package com.od.crowdy.user.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_roles")
public class UserRoles extends com.od.crowdy.shared.domain.model.UserRoles {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
