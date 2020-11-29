package com.od.crowdy.project.handler;

import com.od.crowdy.project.dto.ProjectDto;
import com.od.crowdy.project.facade.ProjectFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class ProjectHandler {
    public final static String PROJECT_ID = "projectId";
    private final ProjectFacade projectFacade;

    public Mono<ServerResponse> getProjectById(ServerRequest serverRequest) {
        return ok()
            .body(projectFacade.getProjectById(serverRequest.pathVariable(PROJECT_ID)), ProjectDto.class);
    }
}
