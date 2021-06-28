package com.od.crowdy.project.cache;

import com.od.crowdy.project.dto.CategoryDto;
import reactor.core.publisher.Flux;

public interface CategoryCacheService {
    Flux<CategoryDto> getAllCategories();
}
