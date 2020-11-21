package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.dto.CategoryDto;
import reactor.core.publisher.Flux;

public interface CategoryFacade {
    Flux<CategoryDto> getAllCategories();
}
