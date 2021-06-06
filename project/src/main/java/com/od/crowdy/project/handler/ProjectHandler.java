package com.od.crowdy.project.handler;

import com.od.crowdy.project.dto.ProjectDto;
import com.od.crowdy.project.facade.ProjectFacade;
import com.od.crowdy.project.request.LikeRequest;
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
    public final static String USER_ID = "userId";
    private final ProjectFacade projectFacade;

    public Mono<ServerResponse> getProjectById(ServerRequest serverRequest) {
        return ok()
            .body(
                projectFacade.getProjectById(serverRequest.pathVariable(PROJECT_ID)),
                ProjectDto.class
            );
    }

    public Mono<ServerResponse> getProjectsByUserId(ServerRequest serverRequest) {
        return ok()
            .body(
                projectFacade.getProjectByUserId(serverRequest.pathVariable(USER_ID)),
                ProjectDto.class
            );
    }

    public Mono<ServerResponse> saveProjectLike(ServerRequest request) {
        return ok()
            .body(
                this.projectFacade.saveProjectLike(request.bodyToMono(LikeRequest.class)),
                ProjectDto.class
            );
    }


    public Mono<ServerResponse> deleteProjectLike(ServerRequest request) {
        return ok()
            .body(
                this.projectFacade.deleteProjectLike(request.pathVariable(USER_ID), request.pathVariable(PROJECT_ID)),
                Void.class
            );
    }
}
