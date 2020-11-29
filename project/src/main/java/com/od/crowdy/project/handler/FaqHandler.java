package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.FaqRepository;
import com.od.crowdy.project.domain.neo4j.model.Faq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class FaqHandler {
    private final FaqRepository faqRepository;

    public Mono<ServerResponse> getFaqsByProjectId(ServerRequest serverRequest) {
        return ok()
            .body(
                faqRepository.findFaqsByProjectId(serverRequest.pathVariable(ProjectHandler.PROJECT_ID)),
                Faq.class
            );
    }
}
