package com.od.crowdy.user.service.impl;

import com.od.crowdy.user.domain.model.Role;
import com.od.crowdy.user.repository.UserRoleRepository;
import com.od.crowdy.user.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultUserRoleService implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Flux<Role> saveAll(Flux<Role> model) {
        return userRoleRepository.saveAll(model);
    }

    @Override
    public Mono<Void> deleteById(String userRolesId) {
        return this.userRoleRepository.deleteById(userRolesId);
    }

    @Override
    public Mono<Role> findById(String id) {
        return this.userRoleRepository.findById(id);
    }

    @Override
    public Flux<Role> findAll() {
        return this.userRoleRepository.findAll();
    }
}
