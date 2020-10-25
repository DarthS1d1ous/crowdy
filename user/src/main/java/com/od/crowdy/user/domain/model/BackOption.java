package com.od.crowdy.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("back_option")
@Builder
public class BackOption {
    @Id
    private String id;
    private String pledge;
    private String reward;
    private Integer backers;
}
