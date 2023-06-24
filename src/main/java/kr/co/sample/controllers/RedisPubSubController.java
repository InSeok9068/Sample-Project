package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultResponseDto;
import kr.co.sample.services.RedisPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "3. Redis Pub/Sub")
@RequestMapping(value = "/example/redis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisPubSubController {

    private final RedisPubService redisPubService;

    @Operation(summary = "메시지 발행")
    @PostMapping(value = "/publish")
    public ResultResponseDto publish() {
        redisPubService.publish("메시지 발행");
        return ResultResponseDto.ofSuccess();
    }
}
