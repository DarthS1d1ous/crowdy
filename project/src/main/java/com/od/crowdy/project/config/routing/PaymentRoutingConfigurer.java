package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.PaymentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class PaymentRoutingConfigurer implements RoutingConfigurer {
    private final PaymentHandler paymentHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/payments"), paymentHandler::findAllPayments)
                .andRoute(GET("/payments/{id}"), paymentHandler::findPaymentById)
                .andRoute(POST("/payments"), paymentHandler::savePayment)
                .andRoute(DELETE("/payments/{id}"), paymentHandler::deletePaymentById);
    }
}
