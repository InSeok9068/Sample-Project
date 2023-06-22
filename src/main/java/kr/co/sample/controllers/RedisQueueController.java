package kr.co.sample.controllers;

import kr.co.sample.dtos.common.ResultResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example/redis/queue", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisQueueController {

    @PostMapping(value = StringUtils.EMPTY)
    public ResultResponseDto insertQueue() {
        return ResultResponseDto.ofError();
    }
}
