package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.dao.UserRepository;
import com.od.crowdy.user.dao.neo4j.model.User;
import com.od.crowdy.user.domain.dto.UserDto;
import com.od.crowdy.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {
    private final UserRepository userRepository;

    @Override
    public Mono<UserDto> getAuthor(String projectId) {
        return userRepository.getAuthor(projectId).map(User::toDto);
    }

    @Override
    public Mono<UserDto> save(Mono<UserDto> user) {
        return user.flatMap(userDto -> userRepository.save(User.from(userDto)))
                .map(UserDto::from);
    }
}
