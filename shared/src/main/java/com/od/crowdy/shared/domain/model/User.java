package com.od.crowdy.shared.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
