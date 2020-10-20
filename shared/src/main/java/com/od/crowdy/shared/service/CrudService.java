package com.od.crowdy.shared.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T> {
    Flux<T> saveAll(Flux<T> models);

    Mono<Void> deleteAll(Flux<T> models);

    Mono<T> findById(String id);

    Flux<T> findAll();
}
