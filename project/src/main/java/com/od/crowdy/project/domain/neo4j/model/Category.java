package com.od.crowdy.project.domain.neo4j.model;

import com.od.crowdy.project.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.support.UUIDStringGenerator;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Node("Category")
public class Category {

    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String name;


    public static CategoryDto toDto(Category category) {
        return CategoryDto.from(category);
    }
}
