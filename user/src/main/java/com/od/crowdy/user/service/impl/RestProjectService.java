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

    @Value("${gateway.service.uri}")
    private String gatewayServiceUri;

    public Flux<ProjectDto> getCreatedProjectsByUserId(String userId) {
        return this.webClient.get()
            .uri(this.gatewayServiceUri + "/projects/created/users/" + userId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(ProjectDto.class);
    }

    public Flux<ProjectDto> getBackedProjectsByUserId(String userId) {
        return this.webClient.get()
            .uri(this.gatewayServiceUri + "/projects/backed/users/" + userId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(ProjectDto.class);
    }
}
