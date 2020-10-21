package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.domain.model.UserRoles;
import com.od.crowdy.user.facade.UserRolesFacade;
import com.od.crowdy.user.service.UserRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserRolesFacade implements UserRolesFacade {
    private final UserRolesService userRolesService;

    @Override
    public Mono<UserRoles> findUserRoleById(String id) {
        return userRolesService.findById(id);
    }

    @Override
    public Mono<UserRoles> saveUserRole(Mono<UserRoles> userRole) {
        return userRolesService.save(userRole);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return userRolesService.deleteById(id);
    }

    @Override
    public Flux<UserRoles> findAllUserRoles() {
        return userRolesService.findAll();
    }
}
