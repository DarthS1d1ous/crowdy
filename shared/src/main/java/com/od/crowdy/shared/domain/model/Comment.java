package com.od.crowdy.shared.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String id;
    private LocalDate createdAt;
    private User author;
    private String message;
    private List<User> likes;
}
