package com.od.crowdy.user.repository;

import com.od.crowdy.user.domain.model.Role;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends ReactiveNeo4jRepository<Role, String> {
}
