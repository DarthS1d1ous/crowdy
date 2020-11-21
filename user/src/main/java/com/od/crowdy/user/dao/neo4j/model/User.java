package com.od.crowdy.user.dao.neo4j.model;

import com.od.crowdy.user.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.driver.Value;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("User")
public class User {

    @Id
    private String id;
    private String username;
    private String login;
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;
    private String avatar;

    public static User mappingFunction(Value value) {
        return User.builder()
                .id(value.get("id").asString())
                .username(value.get("username").asString())
                .login(value.get("login").asString())
                .fullName(value.get("fullName").asString())
                .createdAt(value.get("createdAt").asLocalDate())
                .birthday(value.get("birthday").asLocalDate())
                .avatar(value.get("avatar").asString())
                .build();
    }

    public static UserDto toDto(User user) {
        return UserDto.from(user);
    }

    public static User from(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .login(userDto.getLogin())
                .fullName(userDto.getFullName())
                .createdAt(userDto.getCreatedAt())
                .birthday(userDto.getBirthday())
                .avatar(userDto.getAvatar())
                .build();
    }
}
