package com.od.crowdy.project.config.routing;

import com.od.crowdy.project.handler.FaqHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RequiredArgsConstructor
@Component
public class FaqRoutingConfigurer implements RoutingConfigurer {
    private final FaqHandler faqHandler;

    @Override
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/faqs"), faqHandler::findAllFaqs)
                .andRoute(GET("/faqs/:id"), faqHandler::findFaqById)
                .andRoute(POST("/faqs"), faqHandler::saveFaq)
                .andRoute(DELETE("/faqs/:id"), faqHandler::deleteFaqById);
    }
}
