package com.od.crowdy.user.service.impl;

import com.od.crowdy.user.domain.neo4j.model.User;
import com.od.crowdy.user.domain.neo4j.repository.UserRepository;
import com.od.crowdy.user.request.AuthRequest;
import com.od.crowdy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
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

    @Override
    public Flux<User> getFollowersByUserId(String userId) {
        return this.userRepository.getFollowersByUserId(userId);
    }

    @Override
    public Flux<User> getFollowingByUserId(String userId) {
        return this.userRepository.getFollowingByUserId(userId);
    }

    @Override
    public Mono<User> saveUserFollower(String followerUserId, String followingUserId) {
        return this.userRepository.saveUserFollower(followerUserId, followingUserId);
    }

    @Override
    public Mono<User> deleteUserFollower(String followerId, String followingId) {
        return this.userRepository.deleteUserFollower(followerId, followingId);
    }

    private Mono<User> verifyPassword(AuthRequest authReq, User user) {
        return authReq.getPassword().equals(user.getPassword())
            ? Mono.just(user)
            : Mono.empty();
    }
}
