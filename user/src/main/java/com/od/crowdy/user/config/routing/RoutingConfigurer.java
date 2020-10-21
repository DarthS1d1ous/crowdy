package com.od.crowdy.user.config.routing;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public interface RoutingConfigurer {
    RouterFunction<ServerResponse> routes();
}
