package com.od.crowdy.shared.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T> {
    Mono<T> save(T model);

    Mono<Void> delete(T model);

    Mono<T> findById(String id);

    Flux<T> findAll();
}
