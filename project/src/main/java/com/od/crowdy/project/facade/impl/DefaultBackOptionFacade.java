package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.BackOption;
import com.od.crowdy.project.facade.BackOptionFacade;
import com.od.crowdy.project.service.BackOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultBackOptionFacade implements BackOptionFacade {
    private final BackOptionService backOptionService;

    @Override
    public Mono<BackOption> findBackOptionById(String id) {
        return backOptionService.findById(id);
    }

    @Override
    public Flux<BackOption> saveAllBackOptions(Flux<BackOption> backOption) {
        return backOptionService.saveAll(backOption);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return backOptionService.deleteById(id);
    }

    @Override
    public Flux<BackOption> findAllBackOptions() {
        return backOptionService.findAll();
    }
}
