package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.cache.CategoryCacheService;
import com.od.crowdy.project.domain.neo4j.model.Category;
import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.facade.CategoryFacade;
import com.od.crowdy.project.helper.ProjectHelper;
import com.od.crowdy.project.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Log4j2
@RequiredArgsConstructor
public class MainPageCategoryFacade implements CategoryFacade {
    private final CategoryService categoryService;
    private final ProjectHelper projectHelper;
    private final CategoryCacheService categoryCacheService;

    private final ServerProperties serverProperties;

    @Override
    public Flux<CategoryDto> getAllCategories() {
        log.info("project-server " + this.serverProperties.getPort());
        return this.categoryService.getAllCategories()
            .map(Category::toDto)
            .flatMap(projectHelper::fillProjects);
    }
}
