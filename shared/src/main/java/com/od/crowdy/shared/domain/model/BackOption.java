package com.od.crowdy.shared.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("back_option")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BackOption {
    @Id
    private String id;

    private String pledge;
    private String reward;
    private Integer backers;
}
