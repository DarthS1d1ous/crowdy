package com.od.crowdy.user.service.impl;

import com.od.crowdy.user.domain.model.User;
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
    public Mono<User> save(Mono<User> user) {
        return this.userRepository.save(user);
    }

    @Override
    public Mono<Void> deleteById(String userId) {
        return this.userRepository.deleteById(userId);
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
