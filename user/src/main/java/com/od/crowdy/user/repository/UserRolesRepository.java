package com.od.crowdy.user.repository;

import com.od.crowdy.shared.domain.model.UserRoles;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends ReactiveMongoRepository<UserRoles, String> {
}
