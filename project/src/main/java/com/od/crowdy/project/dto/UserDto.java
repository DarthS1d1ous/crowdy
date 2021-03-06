package com.od.crowdy.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.od.crowdy.project.domain.neo4j.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String id;
    private String username;
    private String fullName;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate createdAt;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthday;
    private String avatar;
    private String about;
    private List<RoleDto> roles;


    public static UserDto from(User user) {
        return UserDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .fullName(user.getFullName())
            .createdAt(user.getCreatedAt())
            .birthday(user.getBirthday())
            .avatar(user.getAvatar())
            .about(user.getAbout())
            .build();
    }

    public static User toModel(UserDto userDto) {
        return User.from(userDto);
    }

}
