package com.od.crowdy.user.domain.neo4j.model;

import com.od.crowdy.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("User")
public class User {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String username;
    private String password;
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;
    private String avatar;

    public static UserDto toDto(User user) {
        return UserDto.from(user);
    }

    public static User from(UserDto userDto) {
        return User.builder()
            .id(userDto.getId())
            .username(userDto.getUsername())
            .fullName(userDto.getFullName())
            .createdAt(userDto.getCreatedAt())
            .birthday(userDto.getBirthday())
            .avatar(userDto.getAvatar())
            .build();
    }
}
