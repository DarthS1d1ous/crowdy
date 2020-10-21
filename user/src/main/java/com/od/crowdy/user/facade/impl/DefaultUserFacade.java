package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.domain.model.User;
import com.od.crowdy.user.facade.UserFacade;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {
    private final UserService userService;

    @Override
    public Mono<User> findUserById(String id) {
        return userService.findById(id);
    }

    @Override
    public Mono<User> saveUser(Mono<User> user) {
        return userService.save(user);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return userService.deleteById(id);
    }

    @Override
    public Flux<User> findAllUsers() {
        return userService.findAll();
    }
}
