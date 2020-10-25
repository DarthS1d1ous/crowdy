package com.od.crowdy.project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
@Builder
public class User {
    private String id;
    private String username;
    private String login;
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;
    private List<User> likedBy;
    private List<User> followings;
    private List<User> followers;
    private List<User> blocked;
    private List<Project> likesProjects;
    private List<Project> projects;
    private List<Project> backed;
    private UserRoles role;
}
