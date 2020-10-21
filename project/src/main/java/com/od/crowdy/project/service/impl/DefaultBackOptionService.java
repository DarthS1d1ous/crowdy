package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.model.BackOption;
import com.od.crowdy.project.repository.BackOptionRepository;
import com.od.crowdy.project.service.BackOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultBackOptionService implements BackOptionService {

    private final BackOptionRepository backOptionRepository;

    @Override
    public Mono<BackOption> save(Mono<BackOption> backOption) {
        return this.backOptionRepository.save(backOption);
    }

    @Override
    public Mono<Void> deleteById(String backOptionId) {
        return this.backOptionRepository.deleteById(backOptionId);
    }

    @Override
    public Mono<BackOption> findById(String id) {
        return this.backOptionRepository.findById(id);
    }

    @Override
    public Flux<BackOption> findAll() {
        return this.backOptionRepository.findAll();
    }
}
