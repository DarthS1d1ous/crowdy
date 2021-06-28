package com.od.crowdy.project.cache.impl;

import com.google.gson.Gson;
import com.od.crowdy.project.cache.ProjectCacheService;
import com.od.crowdy.project.dto.ProjectDetailsDto;
import com.od.crowdy.project.facade.ProjectFacade;
import com.od.crowdy.project.helper.gson.GsonHelper;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RMapReactive;
import org.redisson.api.RedissonReactiveClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProjectCacheServiceImpl implements ProjectCacheService {

    private final RedissonReactiveClient reactiveClient;
    private final ProjectFacade projectFacade;
    private final GsonHelper gsonHelper;
    private final Gson gson;

    @Override
    public Mono<ProjectDetailsDto> getProjectDetailsByProjectId(String projectId) {
        RMapReactive<String, String> mapReactive =
            reactiveClient.getMap("projectDetails");
//        this.projectFacade.getProjectDetailsByProjectId(projectId)
//            .doOnNext(projectDetailsDto -> System.out.println(projectDetailsDto.getId()))
//            .doOnNext(projectDetailsDto -> System.out.println(this.gson.toJson(projectDetailsDto)))
//            .flatMap(projectDetailsDto -> mapReactive.put("111111", this.gson.toJson(projectDetailsDto)))
//            .then(mapReactive.get("111111"))
//            .doOnNext(projectDetailsDto -> System.out.println(this.gson.toJson(projectDetailsDto)))
//            .subscribe();
        return mapReactive.get(projectId)
            .flatMap(json -> this.gsonHelper.getMonoFromJsonString(json, ProjectDetailsDto.class))
            .switchIfEmpty(this.projectFacade.getProjectDetailsByProjectId(projectId)
                .flatMap(projectDetailsDto -> mapReactive.put(projectId, this.gson.toJson(projectDetailsDto)))
                .then(mapReactive.get(projectId))
                .flatMap(json -> this.gsonHelper.getMonoFromJsonString(json, ProjectDetailsDto.class))
            );
    }
}
