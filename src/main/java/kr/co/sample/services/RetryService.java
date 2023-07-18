package kr.co.sample.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryService {

    private static int RETRY_CNT = 0;

    @Async // 재시도 하는 로직은 동기통신이면 응답 지연이 발생 할 수 있으므로 비동기 구현 추천
    @Retryable(retryFor = RuntimeException.class, backoff = @Backoff(delay = 5000), maxAttempts = 5)
    public void retry() {
        try {
            if (RETRY_CNT < 3) {
                throw new RuntimeException("에러 발생");
            }
        } finally {
            log.info("재시도 횟수 : {}", RETRY_CNT);
            RETRY_CNT += 1;
        }
    }

    @Recover // 재시도에도 실패 시 해당 복구 메서드 동작
    public void retryRecover(RuntimeException retryRunTimeEx) {
        log.info("재시도 최종 실패 시 복구");
    }
}
