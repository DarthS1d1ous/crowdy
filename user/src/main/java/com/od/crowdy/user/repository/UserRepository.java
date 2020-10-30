package com.od.crowdy.user.repository;

import com.od.crowdy.user.domain.model.User;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveNeo4jRepository<User, String> {
}
