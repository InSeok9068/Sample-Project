package kr.co.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync // 비동기 활성화
@EnableCaching // 캐싱 활성화
@EnableScheduling // 스케줄러 활성화
@EnableJpaAuditing // JPA 자동 값 등록 활성화
@EnableAspectJAutoProxy // AOP 할성화
@SpringBootApplication
public class SampleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleProjectApplication.class, args);
    }

}