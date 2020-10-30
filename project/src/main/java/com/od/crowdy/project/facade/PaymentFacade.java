package com.od.crowdy.project.facade;

import com.od.crowdy.project.domain.model.Payment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentFacade {
    Mono<Payment> findPaymentById(String id);

    Flux<Payment> saveAllPayments(Flux<Payment> payment);

    Mono<Void> deleteById(String id);

    Flux<Payment> findAllPayments();
}
