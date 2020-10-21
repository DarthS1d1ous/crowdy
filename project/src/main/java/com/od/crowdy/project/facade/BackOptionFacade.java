package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.BackOption;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BackOptionFacade {
    Mono<BackOption> findBackOptionById(String id);

    Mono<BackOption> saveBackOption(Mono<BackOption> backOption);

    Mono<Void> deleteById(String id);

    Flux<BackOption> findAllBackOptions();
}
