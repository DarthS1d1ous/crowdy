package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.BackOption;
import com.od.crowdy.project.facade.BackOptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BackOptionHandler {
    private final BackOptionFacade backOptionFacade;

    public Mono<ServerResponse> findBackOptionById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(backOptionFacade.findBackOptionById(serverRequest.pathVariable("id")), BackOption.class);
    }

    public Mono<ServerResponse> saveBackOption(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(backOptionFacade.saveAllBackOptions(serverRequest.bodyToFlux(BackOption.class)), BackOption.class);
    }

    public Mono<ServerResponse> deleteBackOptionById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(backOptionFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllBackOptions(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(backOptionFacade.findAllBackOptions(), BackOption.class);
    }
}
