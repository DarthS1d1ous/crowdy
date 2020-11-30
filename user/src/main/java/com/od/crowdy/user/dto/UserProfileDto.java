package com.od.crowdy.user.dto;

import com.od.crowdy.user.domain.neo4j.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDto {
    private String id;
    private String username;
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;
    private String avatar;
    private List<UserDto> followers;
    private List<UserDto> following;
    private List<ProjectDto> projects;

    public static UserProfileDto from(User user) {
        return UserProfileDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .fullName(user.getFullName())
            .createdAt(user.getCreatedAt())
            .birthday(user.getBirthday())
            .avatar(user.getAvatar())
            .build();
    }
}
