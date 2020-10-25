package com.od.crowdy.user;

import com.od.crowdy.user.domain.model.Project;
import com.od.crowdy.user.domain.model.User;
import com.od.crowdy.user.domain.model.UserRoles;
import com.od.crowdy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.Collections;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class UserApplication {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateUser() {
        User user = User.builder()
                .username("username")
                .login("login")
                .fullName("fullname")
                .createdAt(LocalDate.now())
                .birthday(LocalDate.now())
                .role(UserRoles.builder().role("ADMIN").build())
                .build();
        Project project = Project.builder().name("project_name").build();
        user.setProjects(Collections.singletonList(project));

        userRepository.save(user).subscribe();
    }
}
