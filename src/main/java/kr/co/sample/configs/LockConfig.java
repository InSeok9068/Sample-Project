package kr.co.sample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
public class LockConfig {

    public static final String LOCK_PREFIX = "lock:";

    @Bean
    RedisLockRegistry redisLockRegistry(LettuceConnectionFactory lettuceConnectionFactory) {
        return new RedisLockRegistry(lettuceConnectionFactory, LOCK_PREFIX);
    }
}
