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
    public Mono<User> save(User model) {
        return this.userRepository.save(model);
    }

    @Override
    public Mono<Void> delete(User model) {
        return this.userRepository.delete(model);
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
