package com.od.crowdy.user.handler;

import com.od.crowdy.user.domain.model.UserRoles;
import com.od.crowdy.user.facade.impl.DefaultUserRolesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class UserRolesHandler {
    private final DefaultUserRolesFacade defaultUserRolesFacade;

    public Mono<ServerResponse> findUserRoleById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(defaultUserRolesFacade.findUserRoleById(serverRequest.pathVariable("id")), UserRoles.class);
    }

    public Mono<ServerResponse> saveUserRole(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(defaultUserRolesFacade.saveUserRole(serverRequest.bodyToMono(UserRoles.class)), UserRoles.class);
    }

    public Mono<ServerResponse> deleteUserRoleById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(defaultUserRolesFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllUserRoles(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(defaultUserRolesFacade.findAllUserRoles(), UserRoles.class);
    }
}
