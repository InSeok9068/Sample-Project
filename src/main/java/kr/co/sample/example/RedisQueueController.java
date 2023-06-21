package kr.co.sample.example;

import kr.co.sample.common.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/redis/queue")
public class RedisQueueController {

    @PostMapping(value = StringUtils.EMPTY)
    public BaseResponse insertQueue() {
        return BaseResponse.ofError();
    }
}
