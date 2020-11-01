package com.od.crowdy.user;

import com.od.crowdy.user.repository.UserRepository;
import com.od.crowdy.user.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class UserApplication {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateUserData() {
    }
}
