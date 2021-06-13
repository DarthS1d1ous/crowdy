package com.od.crowdy.project.dto;

import com.od.crowdy.project.domain.neo4j.model.Faq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FaqDto {

    private String id;
    private String question;
    private String answer;

    public static FaqDto from(Faq faq) {
        return FaqDto.builder()
            .id(faq.getId())
            .question(faq.getQuestion())
            .answer(faq.getAnswer())
            .build();
    }
}
