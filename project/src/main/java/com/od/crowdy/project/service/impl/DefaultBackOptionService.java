package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.repository.BackOptionRepository;
import com.od.crowdy.project.service.BackOptionService;
import com.od.crowdy.shared.domain.model.BackOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultBackOptionService implements BackOptionService {

    private final BackOptionRepository backOptionRepository;

    @Override
    public Flux<BackOption> saveAll(Flux<BackOption> models) {
        return this.backOptionRepository.saveAll(models);
    }

    @Override
    public Mono<Void> deleteAll(Flux<BackOption> models) {
        return this.backOptionRepository.deleteAll(models);
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
