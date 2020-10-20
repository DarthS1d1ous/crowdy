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
    public Flux<UserRoles> saveAll(Flux<UserRoles> models) {
        return this.userRolesRepository.saveAll(models);
    }

    @Override
    public Mono<Void> deleteAll(Flux<UserRoles> models) {
        return this.userRolesRepository.deleteAll(models);
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
