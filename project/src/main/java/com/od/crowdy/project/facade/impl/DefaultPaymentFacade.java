package com.od.crowdy.project.facade.impl;

import com.od.crowdy.project.domain.model.Payment;
import com.od.crowdy.project.facade.PaymentFacade;
import com.od.crowdy.project.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DefaultPaymentFacade implements PaymentFacade {
    private final PaymentService paymentService;

    @Override
    public Mono<Payment> findPaymentById(String id) {
        return paymentService.findById(id);
    }

    @Override
    public Flux<Payment> saveAllPayments(Flux<Payment> payment) {
        return paymentService.saveAll(payment);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return paymentService.deleteById(id);
    }

    @Override
    public Flux<Payment> findAllPayments() {
        return paymentService.findAll();
    }
}
