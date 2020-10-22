package com.od.crowdy.user.facade;

import com.od.crowdy.user.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserFacade {
    Mono<User> findUserById(String id);

    Flux<User> saveAllUsers(Flux<User> user);

    Mono<Void> deleteById(String id);

    Flux<User> findAllUsers();
}
