package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.services.RetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-7. 재시도")
@RequestMapping(value = "/retry", produces = MediaType.APPLICATION_JSON_VALUE)
public class RetryController {

    private final RetryService retryService;

    @Operation(summary = "재시도 요청")
    @GetMapping(value = "/call")
    ResultDto callRetry() {
        retryService.retry();
        return ResultDto.ofSuccess();
    }
}
