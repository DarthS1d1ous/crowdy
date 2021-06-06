package com.od.crowdy.user.service.impl;

import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.domain.neo4j.repository.UserRepository;
import com.od.crowdy.user.request.AuthRequest;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

//    @Override
//    public Mono<User> save(User user) {
//        return this.userRepository.save(user);
//    }
//
//    @Override
//    public Mono<Boolean> isUserExists(String username) {
//        return this.userRepository.isUserExists(username);
//    }

    @Override
    public Mono<User> registerUser(User user) {
        return this.userRepository.isUserExists(user.getUsername())
            .flatMap(isExist -> !isExist
                ? this.userRepository.save(user)
                : Mono.empty());
    }

    @Override
    public Mono<User> login(AuthRequest authRequest) {
        return this.userRepository.getUserByUsername(authRequest.getUsername())
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.OK, "12345")))
            .flatMap(user -> verifyPassword(authRequest, user));
    }

    @Override
    public Flux<User> getUserLikesByProjectId(String projectDto) {
        return this.userRepository.getUserLikesByProjectId(projectDto);
    }

    @Override
    public Mono<User> getAuthorByCommentId(String commentId) {
        return this.userRepository.getAuthorByCommentId(commentId);
    }

    @Override
    public Mono<User> getUserById(String userId) {
        return this.userRepository.getUserById(userId);
    }

    @Override
    public Mono<User> getAuthorByProjectId(String projectId) {
        return this.userRepository.getAuthorByProjectId(projectId);
    }

    private Mono<User> verifyPassword(AuthRequest authReq, User user) {
        return authReq.getPassword().equals(user.getPassword())
            ? Mono.just(user)
            : Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "asddf"));
    }
}
