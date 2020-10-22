package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.Faq;
import com.od.crowdy.project.facade.FaqFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FaqHandler {
    private final FaqFacade faqFacade;

    public Mono<ServerResponse> findFaqById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(faqFacade.findFaqById(serverRequest.pathVariable("id")), Faq.class);
    }

    public Mono<ServerResponse> saveFaq(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(faqFacade.saveAllFaqs(serverRequest.bodyToFlux(Faq.class)), Faq.class);
    }

    public Mono<ServerResponse> deleteFaqById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(faqFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllFaqs(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(faqFacade.findAllFaqs(), Faq.class);
    }
}
