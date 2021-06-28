package com.od.crowdy.project;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.redisson.Redisson;
import org.redisson.api.RMapReactive;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
@EnableEurekaClient
public class ProjectApplication {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        // use "rediss://" for SSL connection

        RedissonClient client = Redisson.create(config);

        RedissonReactiveClient reactiveClient = client.reactive();

        RMapReactive<String, String> mapReactive = reactiveClient.getMap("myMap");
        mapReactive.put("Lesha", "Korona")
            .then(mapReactive.get("Lesha"))
            .subscribe(System.out::println);
//        mapReactive.put("Lesha", "Korona");
//        Mono<String> get = mapReactive.get("Lesha");
//        get.doOnSuccess(System.out::println)
//            .subscribe();

        SpringApplication.run(ProjectApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void serviceStarted() {
        log.info("Server has started! {}", LocalDateTime.now());
    }

}
