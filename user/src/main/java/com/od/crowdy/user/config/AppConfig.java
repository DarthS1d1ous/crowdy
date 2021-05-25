package com.od.crowdy.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    ExchangeStrategies exchangeStrategies() {
        return ExchangeStrategies
            .builder()
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(5000000))
            .build();
    }

    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.exchangeStrategies(exchangeStrategies())
            .build();
    }
}
