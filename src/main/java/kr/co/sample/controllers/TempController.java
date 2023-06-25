package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-1. 임시")
@RequestMapping(value = "/temp", produces = MediaType.APPLICATION_JSON_VALUE)
public class TempController {

    @Operation(summary = "요청")
    @GetMapping(value = StringUtils.EMPTY)
    public ResultDto getTemp() {
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "에러 발생")
    @GetMapping(value = "/error")
    public ResultDto throwException() throws Exception {
        throw new Exception("의도적인 에러 발생");
    }
}
