package com.od.crowdy.user.service.impl;

import com.od.crowdy.user.dto.ProjectDto;
import com.od.crowdy.user.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RestProjectService implements ProjectService {
    private final WebClient webClient;

    @Value("${projectservice.uri}")
    private String projectServiceUri;

    @Override
    public Flux<ProjectDto> getProjectsByUserId(String userId) {
        return webClient.get()
            .uri(projectServiceUri + "/projects/user/" + userId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(ProjectDto.class);
    }
}
