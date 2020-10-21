package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.Faq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FaqFacade {
    Mono<Faq> findFaqById(String id);

    Mono<Faq> saveFaq(Mono<Faq> faq);

    Mono<Void> deleteById(String id);

    Flux<Faq> findAllFaqs();
}
