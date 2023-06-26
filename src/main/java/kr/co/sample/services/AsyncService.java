package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultGenericDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<ResultGenericDto<String>> callAsync() {
        return CompletableFuture.completedFuture(ResultGenericDto.ofSuccess("Hello"));
    }
}
