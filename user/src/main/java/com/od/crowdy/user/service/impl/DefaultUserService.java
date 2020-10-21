package com.od.crowdy.user.service.impl;

import com.od.crowdy.shared.domain.model.User;
import com.od.crowdy.user.repository.UserRepository;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Flux<User> saveAll(Flux<User> models) {
        return this.userRepository.saveAll(models);
    }

    @Override
    public Mono<Void> deleteAll(Flux<User> models) {
        return this.userRepository.deleteAll(models);
    }

    @Override
    public Mono<User> findById(String id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }
}
