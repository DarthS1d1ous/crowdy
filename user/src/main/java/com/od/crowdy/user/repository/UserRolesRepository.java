package com.od.crowdy.user.repository;

import com.od.crowdy.user.domain.model.UserRoles;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRolesRepository extends ReactiveMongoRepository<UserRoles, String> {
    Mono<UserRoles> save(Mono<UserRoles> userRoles);
}
