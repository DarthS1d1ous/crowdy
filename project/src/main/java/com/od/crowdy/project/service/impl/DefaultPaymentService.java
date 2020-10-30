package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.model.Payment;
import com.od.crowdy.project.repository.PaymentRepository;
import com.od.crowdy.project.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultPaymentService implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Flux<Payment> saveAll(Flux<Payment> model) {
        return paymentRepository.saveAll(model);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return paymentRepository.deleteById(id);
    }

    @Override
    public Mono<Payment> findById(String id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Flux<Payment> findAll() {
        return paymentRepository.findAll();
    }
}
