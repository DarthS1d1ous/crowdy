package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.repository.FaqRepository;
import com.od.crowdy.project.service.FaqService;
import com.od.crowdy.shared.domain.model.Faq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultFaqService implements FaqService {

    private final FaqRepository faqRepository;

    @Override
    public Flux<Faq> saveAll(Flux<Faq> models) {
        return this.faqRepository.saveAll(models);
    }

    @Override
    public Mono<Void> deleteAll(Flux<Faq> models) {
        return this.faqRepository.deleteAll(models);
    }

    @Override
    public Mono<Faq> findById(String id) {
        return this.faqRepository.findById(id);
    }

    @Override
    public Flux<Faq> findAll() {
        return this.faqRepository.findAll();
    }
}
