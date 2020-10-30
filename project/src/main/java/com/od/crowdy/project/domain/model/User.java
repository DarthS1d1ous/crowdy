package com.od.crowdy.project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("user")
@Builder
public class User {

    @Id
    private String id;
    private String username;
    private String login;
    private String fullName;
    private LocalDate createdAt;
    private LocalDate birthday;

    @Relationship(type = "LIKES", direction = Relationship.Direction.OUTGOING)
    private Set<User> likedUsers;

    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private Set<User> followingUsers;

    @Relationship(type = "BLOCKS", direction = Relationship.Direction.OUTGOING)
    private Set<User> blockedUsers;

    @Relationship(type = "OWNS", direction = Relationship.Direction.OUTGOING)
    private Set<Project> createdProjects;

    @Relationship(type = "CREATES", direction = Relationship.Direction.OUTGOING)
    private Set<Comment> createdComments;

    @Relationship(type = "LIKES", direction = Relationship.Direction.OUTGOING)
    private Set<Comment> likedComments;

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private Set<Role> roles;

    @Relationship(type = "PAYS", direction = Relationship.Direction.OUTGOING)
    private Set<Payment> payments;
}
