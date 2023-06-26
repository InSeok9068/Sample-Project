package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultGenericDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async
    public CompletableFuture<ResultGenericDto<String>> callAsync() {
        log.info("callAsync start");
        return CompletableFuture.completedFuture(ResultGenericDto.ofSuccess("Hello"));
    }
}
