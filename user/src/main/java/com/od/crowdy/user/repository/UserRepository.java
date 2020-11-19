package com.od.crowdy.user.repository;

import com.od.crowdy.user.repository.neo4j.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> getAuthor(String projectId);
}
