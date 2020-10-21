package com.od.crowdy.project.config.routing;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

public interface RoutingConfigurer {
    RouterFunction<ServerResponse> routes();
}
