package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultResponseDto;
import kr.co.sample.services.CircuitBreakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "4. 서킷브레이커")
@RequestMapping(value = "/circuit-breaker", produces = MediaType.APPLICATION_JSON_VALUE)
public class CircuitBreakerController {

    private final CircuitBreakerService circuitBreakerService;

    @Operation(summary = "요청")
    @GetMapping(value = "/call")
    public ResultResponseDto callApi(@RequestParam(defaultValue = "false") boolean isError) {
        return circuitBreakerService.callApi(isError);
    }
}
