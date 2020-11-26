package com.od.crowdy.project.domain.dto;

import com.od.crowdy.project.dao.neo4j.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String id;
    private String username;
    private String login;
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;
    private String avatar;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .login(user.getLogin())
                .fullName(user.getFullName())
                .createdAt(user.getCreatedAt())
                .birthday(user.getBirthday())
                .avatar(user.getAvatar())
                .build();
    }

    public static User toModel(UserDto userDto) {
        return User.from(userDto);
    }

}
