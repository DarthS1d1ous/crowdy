package com.od.crowdy.shared.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T> {
    Mono<T> save(Mono<T> model);

    Mono<Void> deleteById(String id);

    Mono<T> findById(String id);

    Flux<T> findAll();
}
