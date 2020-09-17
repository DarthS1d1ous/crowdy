package com.od.crowdy.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
@Log4j2
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void serviceStarted() {
		log.info("Server has started! {}", LocalDateTime.now());
	}
}
