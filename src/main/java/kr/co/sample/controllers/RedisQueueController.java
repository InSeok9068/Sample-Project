package kr.co.sample.controllers;

import kr.co.sample.dtos.common.BaseResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/redis/queue")
public class RedisQueueController {

    @PostMapping(value = StringUtils.EMPTY)
    public BaseResponseDto insertQueue() {
        return BaseResponseDto.ofError();
    }
}
