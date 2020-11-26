package com.od.crowdy.user.domain.neo4j;

import com.od.crowdy.user.domain.neo4j.model.Role;
import reactor.core.publisher.Flux;

public interface RoleRepository {
    Flux<Role> getRolesByUserId(String userId);
}
