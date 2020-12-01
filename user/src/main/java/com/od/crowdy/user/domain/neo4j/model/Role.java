package com.od.crowdy.user.domain.neo4j.model;

import com.od.crowdy.user.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.Node;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Role")
public class Role {
    public static final String ADMIN = "admin";
    public static final String USER = "user";

    @Id
    private String id;
    private String name;

    public static RoleDto toDto(Role role) {
        return RoleDto.from(role);
    }
}
