package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.services.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-5. 비동기")
@RequestMapping(value = "/async", produces = MediaType.APPLICATION_JSON_VALUE)
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping(value = "/call")
    CompletableFuture<ResultGenericDto<String>> callAsync() {
        return asyncService.callAsync();
    }
}
