package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.neo4j.model.Category;
import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.facade.CategoryFacade;
import com.od.crowdy.project.helper.ProjectHelper;
import com.od.crowdy.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class MainPageCategoryFacade implements CategoryFacade {
    private final CategoryService categoryService;
    private final ProjectHelper projectHelper;

    @Override
    public Flux<CategoryDto> getAllCategories() {
        return this.categoryService
            .getAllCategories()
            .map(Category::toDto)
            .flatMap(projectHelper::fillProjects);
    }
}
