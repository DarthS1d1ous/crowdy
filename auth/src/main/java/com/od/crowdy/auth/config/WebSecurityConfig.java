package com.od.crowdy.auth.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFluxSecurity
@Log4j2
public class WebSecurityConfig implements WebFluxConfigurer {

    @Value("${frontend.uri}")
    private String frontendUri;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                .httpBasic().and()
                .authorizeExchange()
                .pathMatchers("/**").permitAll()// FUCKING TRASH SPRING SECURITY, IF YOU WANT TO RESTRICT SOME ENDPOINTS ADD THEM ABOVE
                .anyExchange().authenticated().and()
                .build();
    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins(frontendUri)
                .allowedMethods("PUT", "GET", "POST")
                .maxAge(3600);
    }
}
