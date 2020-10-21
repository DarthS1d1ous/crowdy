package com.od.crowdy.user.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User extends com.od.crowdy.shared.domain.model.User {
    @Id
    @Override
    public String getId() {
        return super.getId();
    }
}
