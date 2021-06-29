package com.od.crowdy.project.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class RedisConfig {

//    @Value("${redis.port}")
//    private String REDIS_PORT;
//    private static final String REDIS_PROTOCOL_PREFIX = "redis://";
//    private static final String LOCALHOST = "127.0.0.1:";

    @Value("classpath:/redis/config.yml")
    private Resource redisConfig;

    @Value("${redis.address}")
    private String redisAddress;

    @Bean(destroyMethod = "shutdown")
    RedissonReactiveClient redisson() throws IOException {
        System.out.println("================" + this.redisAddress);
        Config config = Config.fromYAML(this.redisConfig.getInputStream());
        config.useSingleServer().setAddress(this.redisAddress);
        return Redisson.create(config).reactive();
    }
}
