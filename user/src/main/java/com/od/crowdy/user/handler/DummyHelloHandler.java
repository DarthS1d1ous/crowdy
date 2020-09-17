package com.od.crowdy.user.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class DummyHelloHandler {

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("{\n" +
                "   \"firstName\": \"Иван\",\n" +
                "   \"lastName\": \"Иванов\",\n" +
                "   \"address\": {\n" +
                "       \"streetAddress\": \"Московское ш., 101, кв.101\",\n" +
                "       \"city\": \"Ленинград\",\n" +
                "       \"postalCode\": 101101\n" +
                "   },\n" +
                "   \"phoneNumbers\": [\n" +
                "       \"812 123-1234\",\n" +
                "       \"916 123-4567\"\n" +
                "   ]\n" +
                "}");
    }
}
