package com.od.crowdy.user.domain.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Builder
public class User extends com.od.crowdy.shared.domain.model.User {
}
