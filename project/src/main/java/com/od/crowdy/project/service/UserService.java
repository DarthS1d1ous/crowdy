package com.od.crowdy.project.service;

import com.od.crowdy.project.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> getAuthorByProjectId(String projectId);

    Flux<UserDto> getUserLikesByProject(String projectDto);

    Mono<UserDto> getAuthorByCommentId(String commentId);

    Mono<UserDto> getUserById(String userId);
}
