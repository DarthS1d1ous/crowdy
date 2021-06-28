package com.od.crowdy.project.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

@Configuration
public class RedisConfig {

//    @Value("${redis.port}")
//    private String REDIS_PORT;
//    private static final String REDIS_PROTOCOL_PREFIX = "redis://";
//    private static final String LOCALHOST = "127.0.0.1:";

    @Bean(destroyMethod = "shutdown")
    RedissonReactiveClient redisson() throws IOException {
        Config config = Config.fromYAML(ResourceUtils.getFile("classpath:redis/config.yaml"));
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config).reactive();
    }
}
