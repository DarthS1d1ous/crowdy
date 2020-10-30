package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.domain.model.Role;
import com.od.crowdy.user.facade.UserRoleFacade;
import com.od.crowdy.user.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserRoleFacade implements UserRoleFacade {
    private final UserRoleService userRoleService;

    @Override
    public Mono<Role> findUserRoleById(String id) {
        return userRoleService.findById(id);
    }

    @Override
    public Flux<Role> saveAllUserRoles(Flux<Role> userRole) {
        return userRoleService.saveAll(userRole);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return userRoleService.deleteById(id);
    }

    @Override
    public Flux<Role> findAllUserRoles() {
        return userRoleService.findAll();
    }
}
