package kr.co.sample.controllers;

import kr.co.sample.dtos.common.ResultResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TempController {

    @GetMapping(value = StringUtils.EMPTY)
    public ResultResponseDto getTemp() {
        return ResultResponseDto.ofSuccess();
    }
}
