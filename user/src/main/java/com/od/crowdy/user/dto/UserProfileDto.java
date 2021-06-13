package com.od.crowdy.user.dto;

import com.od.crowdy.user.domain.neo4j.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class UserProfileDto extends UserDto {
    private List<UserDto> followers;
    private List<UserDto> following;
    private List<ProjectDto> createdProjects;
    private List<ProjectDto> backedProjects;

    public static UserProfileDto from(User user) {
        return UserProfileDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .fullName(user.getFullName())
            .createdAt(user.getCreatedAt())
            .birthday(user.getBirthday())
            .avatar(user.getAvatar())
            .about(user.getAbout())
            .build();
    }

    public static User toModel(UserProfileDto userProfileDto) {
        return User.from(userProfileDto);
    }
}
