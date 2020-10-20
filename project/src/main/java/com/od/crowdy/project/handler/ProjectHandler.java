package com.od.crowdy.project.handler;

import com.od.crowdy.project.facade.ProjectFacade;
import com.od.crowdy.shared.domain.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProjectHandler {

    private final ProjectFacade projectFacade;

    public Mono<ServerResponse> findProjectById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(projectFacade.findProjectById(serverRequest.pathVariable("id")), Project.class);
    }

    public Mono<ServerResponse> saveProject(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(projectFacade.saveAllProjects(serverRequest.bodyToFlux(Project.class)), Project.class);
    }
}
