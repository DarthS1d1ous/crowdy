package com.od.crowdy.project.service;

import com.od.crowdy.project.dao.neo4j.model.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getAuthorByProjectId(String projectId);
}
