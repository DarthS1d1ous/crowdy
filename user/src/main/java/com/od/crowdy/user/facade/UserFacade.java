package com.od.crowdy.user.facade;

import com.od.crowdy.user.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserFacade {
    Mono<User> findUserById(String id);

    Mono<User> saveUser(Mono<User> user);

    Mono<Void> deleteById(String id);

    Flux<User> findAllUsers();
}
