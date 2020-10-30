package com.od.crowdy.user.facade;

import com.od.crowdy.user.domain.model.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRoleFacade {
    Mono<Role> findUserRoleById(String id);

    Flux<Role> saveAllUserRoles(Flux<Role> userRole);

    Mono<Void> deleteById(String id);

    Flux<Role> findAllUserRoles();
}
