package kr.co.sample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.ContextClosedEvent;
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
        SpringApplication application = new SpringApplication(SampleProjectApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }

    /**
     * ■ 어플리케이션 시작 시 이벤트 ■ 이인석 2023-07-05
     */
    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> System.out.println("Hello World");
    }

    /**
     * ■ 어플리케이션 종료 시 이벤트 ■ 이인석 2023-07-05
     */
    @Bean
    public ApplicationListener<ContextClosedEvent> contextClosedEventApplicationListener() {
        return args -> System.out.println("Bye World");
    }
}