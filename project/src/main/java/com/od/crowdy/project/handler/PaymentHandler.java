package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.Payment;
import com.od.crowdy.project.facade.PaymentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PaymentHandler {
    private final PaymentFacade paymentFacade;

    public Mono<ServerResponse> findPaymentById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(paymentFacade.findPaymentById(serverRequest.pathVariable("id")), Payment.class);
    }

    public Mono<ServerResponse> savePayment(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(paymentFacade.saveAllPayments(serverRequest.bodyToFlux(Payment.class)), Payment.class);
    }

    public Mono<ServerResponse> deletePaymentById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(paymentFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllPayments(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(paymentFacade.findAllPayments(), Payment.class);
    }
}
