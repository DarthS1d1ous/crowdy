package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.Faq;
import com.od.crowdy.project.facade.FaqFacade;
import com.od.crowdy.project.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultFaqFacade implements FaqFacade {
    private final FaqService faqService;

    @Override
    public Mono<Faq> findFaqById(String id) {
        return faqService.findById(id);
    }

    @Override
    public Mono<Faq> saveFaq(Mono<Faq> faq) {
        return faqService.save(faq);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return faqService.deleteById(id);
    }

    @Override
    public Flux<Faq> findAllFaqs() {
        return faqService.findAll();
    }
}
