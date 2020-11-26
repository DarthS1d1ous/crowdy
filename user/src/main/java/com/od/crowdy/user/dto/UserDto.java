package com.od.crowdy.user.dto;

import com.od.crowdy.user.domain.neo4j.model.User;
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
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;
    private String avatar;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
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
