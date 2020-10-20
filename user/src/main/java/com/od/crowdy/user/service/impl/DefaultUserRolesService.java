package com.od.crowdy.user.service.impl;

import com.od.crowdy.shared.domain.model.UserRoles;
import com.od.crowdy.user.repository.UserRolesRepository;
import com.od.crowdy.user.service.UserRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultUserRolesService implements UserRolesService {

    private final UserRolesRepository userRolesRepository;

    @Override
    public Mono<UserRoles> save(UserRoles model) {
        return this.userRolesRepository.save(model);
    }

    @Override
    public Mono<Void> delete(UserRoles model) {
        return this.userRolesRepository.delete(model);
    }

    @Override
    public Mono<UserRoles> findById(String id) {
        return this.userRolesRepository.findById(id);
    }

    @Override
    public Flux<UserRoles> findAll() {
        return this.userRolesRepository.findAll();
    }
}
