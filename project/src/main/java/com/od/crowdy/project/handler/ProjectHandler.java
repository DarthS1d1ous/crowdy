package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.Project;
import com.od.crowdy.project.facade.ProjectFacade;
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
                .body(projectFacade.saveProject(serverRequest.bodyToMono(Project.class)), Project.class);
    }

    public Mono<ServerResponse> deleteProjectById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(projectFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllProjects(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(projectFacade.findAllProjects(), Project.class);
    }
}
