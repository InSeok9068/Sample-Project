package kr.co.sample.services;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import kr.co.sample.constants.CircuitBreakerConstant;
import kr.co.sample.dtos.common.ResultDto;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {

    @CircuitBreaker(name = CircuitBreakerConstant.TEST_CIRCUIT_BREAKER, fallbackMethod = "callApiFallback")
    public ResultDto callApi(boolean isError) {
        if (isError) {
            throw new RuntimeException("callApi error");
        } else {
            return ResultDto.ofSuccess();
        }
    }

    private ResultDto callApiFallback(Exception e) {
        if (e instanceof CallNotPermittedException) {
            return ResultDto.ofError(e.getMessage() + " 서킷 브레이커 동작");
        } else {
            return ResultDto.ofError(e.getMessage());
        }
    }
}
