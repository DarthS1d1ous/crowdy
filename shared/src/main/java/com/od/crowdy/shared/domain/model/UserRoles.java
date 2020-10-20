package com.od.crowdy.shared.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoles {
    @Id
    private String id;

    private String role;
}
