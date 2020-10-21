package com.od.crowdy.project.config;

import com.od.crowdy.project.config.routing.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {
    private final ProjectRoutingConfigurer projectRoutingConfigurer;
    private final FaqRoutingConfigurer faqRoutingConfigurer;
    private final CategoriesRoutingConfigurer categoriesRoutingConfigurer;
    private final CommentRoutingConfigurer commentRoutingConfigurer;
    private final BackOptionRoutingConfigurer backOptionRoutingConfigurer;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return projectRoutingConfigurer.routes()
                .and(faqRoutingConfigurer.routes())
                .and(categoriesRoutingConfigurer.routes())
                .and(commentRoutingConfigurer.routes())
                .and(backOptionRoutingConfigurer.routes());

    }
}
