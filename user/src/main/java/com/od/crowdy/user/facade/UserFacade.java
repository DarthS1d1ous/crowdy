package com.od.crowdy.user.facade;

import com.od.crowdy.user.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserFacade {
    Mono<UserDto> getAuthor(String projectId);

    Mono<UserDto> save(Mono<UserDto> user);

    Flux<UserDto> getUserLikesByProjectId(String projectId);
}
