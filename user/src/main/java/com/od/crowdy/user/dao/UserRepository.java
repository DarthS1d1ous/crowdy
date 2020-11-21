package com.od.crowdy.user.dao;

import com.od.crowdy.user.dao.neo4j.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> getAuthor(String projectId);
}
