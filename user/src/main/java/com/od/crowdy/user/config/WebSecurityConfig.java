package com.od.crowdy.user.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
//@EnableWebFluxSecurity
@Log4j2
public class WebSecurityConfig implements WebFluxConfigurer {

    @Value("${frontend.uri}")
    private String frontendUri;

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        return http.csrf().disable()
//                .authorizeExchange()// FUCKING TRASH SPRING SECURITY, IF YOU WANT TO RESTRICT SOME ENDPOINTS ADD THEM ABOVE
//                .anyExchange().authenticated().and()
//                .oauth2Login().and()
//                .build();
//    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
            .allowedOrigins(frontendUri)
            .allowedMethods("PUT", "GET", "POST")
            .maxAge(3600);
    }
}
