package com.od.crowdy.user.dto;

import com.od.crowdy.user.domain.neo4j.model.Project;
import com.od.crowdy.user.domain.neo4j.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto extends UserDto {
    private List<User> followers;
    private List<User> following;
    private List<Project> createdProjects;
    private List<Project> backedProjects;

    public static User toModel(UserProfileDto userProfileDto) {
        return User.from(userProfileDto);
    }
}
