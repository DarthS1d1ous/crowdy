package com.od.crowdy.project.cache.impl;

import com.od.crowdy.project.cache.CategoryCacheService;
import com.od.crowdy.project.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RMapCacheReactive;
import org.redisson.api.RedissonReactiveClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryCacheServiceImpl implements CategoryCacheService {

    private final RedissonReactiveClient reactiveClient;


    @Override
    public Flux<CategoryDto> getAllCategories() {
        System.out.println("--------------------------");
        RMapCacheReactive<String, List<CategoryDto>> projectMap =
            this.reactiveClient.getMapCache("project-microservice");
        projectMap.get("categories")
//            .flatMapMany(Flux::fromIterable)
//            .switchIfEmpty()
//            .flatMap(categoryDtos -> categoryDtos.isEmpty() ? )
            .doOnNext(System.out::println)
            .subscribe();
        System.out.println("--------------------------");

        return projectMap.get("categories").flatMapMany(Flux::fromIterable);
    }
}
