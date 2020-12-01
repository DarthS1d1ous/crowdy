package com.od.crowdy.user.domain.neo4j;

import com.od.crowdy.user.domain.neo4j.model.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoleRepository {
    Flux<Role> getRolesByUserId(String userId);

    Mono<Role> save(String userId, String roleName);
}
