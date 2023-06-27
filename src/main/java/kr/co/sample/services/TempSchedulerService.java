package kr.co.sample.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class TempSchedulerService {

    @Scheduled(cron = "0 0 10 * * ?") // 매월 매일 오전 10시에 실행
    public void schedule() {
        log.info("스케줄러 실행 : {}", LocalDateTime.now());
    }
}
