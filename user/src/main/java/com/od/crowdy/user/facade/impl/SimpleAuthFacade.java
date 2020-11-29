package com.od.crowdy.user.facade.impl;

import com.od.crowdy.user.dao.UserRepository;
import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.dto.AuthRequest;
import com.od.crowdy.user.dto.RegisterUserDto;
import com.od.crowdy.user.dto.UserDto;
import com.od.crowdy.user.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SimpleAuthFacade implements AuthFacade {
    private final UserRepository userRepository;

    @Override
    public Mono<UserDto> login(Mono<AuthRequest> authRequest) {
        return authRequest.flatMap(authReq ->
            userRepository
                .findByUsername(authReq.getUsername())
                .flatMap(user -> verifyPassword(authReq, user))
        )
            .map(User::toDto);
    }

    private Mono<User> verifyPassword(AuthRequest authReq, User user) {
        if (authReq.getPassword().equals(user.getPassword())) {
            return Mono.just(user);
        } else {
            return Mono.empty();
        }
    }

    @Override
    public Mono<UserDto> register(Mono<RegisterUserDto> registerUserDtoMono) {
        return registerUserDtoMono.flatMap(registerUser ->
            userRepository
                .isUserExists(registerUser.getUsername())
                .flatMap(isUserExists -> saveIfNotExists(registerUser, isUserExists))
        )
            .map(User::toDto);
    }

    private Mono<User> saveIfNotExists(RegisterUserDto registerUserDto, Boolean isUserExists) {
        return !isUserExists
            ? userRepository.save(RegisterUserDto.toModel(registerUserDto))
            : Mono.empty();
    }
}
