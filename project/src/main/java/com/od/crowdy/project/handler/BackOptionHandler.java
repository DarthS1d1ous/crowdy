package com.od.crowdy.project.handler;

import com.od.crowdy.project.dto.BackOptionDto;
import com.od.crowdy.project.facade.BackOptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class BackOptionHandler {
    private final BackOptionFacade backOptionFacade;

    public Mono<ServerResponse> getBackOptionsByProjectId(ServerRequest serverRequest) {
        return ok()
            .body(
                backOptionFacade.getBackOptionsByProjectId(serverRequest.pathVariable(ProjectHandler.PROJECT_ID)),
                BackOptionDto.class
            );
    }
}
