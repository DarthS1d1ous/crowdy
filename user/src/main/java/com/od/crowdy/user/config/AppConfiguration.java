package com.od.crowdy.user.config;

import com.od.crowdy.user.config.routing.UserRolesRoutingConfigurer;
import com.od.crowdy.user.config.routing.UserRoutingConfigurer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {
    private final UserRolesRoutingConfigurer userRolesRoutingConfigurer;
    private final UserRoutingConfigurer userRoutingConfigurer;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return userRoutingConfigurer.routes()
                .and(userRolesRoutingConfigurer.routes());
    }
}
