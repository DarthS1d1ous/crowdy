package com.od.crowdy.user.facade;

import com.od.crowdy.user.domain.model.UserRoles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRolesFacade {
    Mono<UserRoles> findUserRoleById(String id);

    Flux<UserRoles> saveAllUserRoles(Flux<UserRoles> userRole);

    Mono<Void> deleteById(String id);

    Flux<UserRoles> findAllUserRoles();
}
