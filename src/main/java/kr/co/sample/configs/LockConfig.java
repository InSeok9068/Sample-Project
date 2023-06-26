package kr.co.sample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.integration.jdbc.lock.DefaultLockRepository;
import org.springframework.integration.jdbc.lock.JdbcLockRegistry;
import org.springframework.integration.jdbc.lock.LockRepository;
import org.springframework.integration.redis.util.RedisLockRegistry;

import javax.sql.DataSource;

@Configuration
public class LockConfig {

    public static final String LOCK_PREFIX = "lock:";

    @Bean
    RedisLockRegistry redisLockRegistry(LettuceConnectionFactory lettuceConnectionFactory) {
        return new RedisLockRegistry(lettuceConnectionFactory, LOCK_PREFIX);
    }

    @Bean
    public LockRepository lockRepository(DataSource datasource) {
        return new DefaultLockRepository(datasource);
    }

    @Bean
    public JdbcLockRegistry jdbcLockRegistry(LockRepository repository) {
        return new JdbcLockRegistry(repository);
    }
}
