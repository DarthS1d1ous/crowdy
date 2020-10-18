package com.od.crowdy.auth;

import com.od.crowdy.auth.model.User;
import com.od.crowdy.auth.model.UserRole;
import com.od.crowdy.auth.repository.MongoUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class AuthApplication {

    private final MongoUserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void serviceStarted() {
        userRepository.findByUsername("plusqred").switchIfEmpty(
                userRepository.save(
                        User.builder()
                                .username("plusqred")
                                .password(new BCryptPasswordEncoder().encode("plusqred"))
                                .role(UserRole.ROLE_USER)
                                .build()
                )
        ).subscribe();

        log.info("Server has started! {}", LocalDateTime.now());
    }

}
