package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.TempDto;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.services.TempService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-1. 임시")
@RequestMapping(value = "/temp", produces = MediaType.APPLICATION_JSON_VALUE)
public class TempController {

    private final TempService tempService;

    @Operation(summary = "리스트 요청")
    @GetMapping(value = "/list")
    ResultGenericDto<List<TempDto>> getTempList() {
        return tempService.getTempList();
    }

    @Operation(summary = "요청")
    @GetMapping(value = StringUtils.EMPTY)
    ResultGenericDto<TempDto> getTemp() {
        return tempService.getTemp(1L);
    }

    @Operation(summary = "요청(JPA Quert)")
    @GetMapping(value = "/query")
    ResultGenericDto<TempDto> getTempForQuery() {
        return tempService.getTempForQuery(1L);
    }

    @Operation(summary = "에러 발생")
    @GetMapping(value = "/error")
    ResultDto throwException() throws Exception {
        throw new Exception("의도적인 에러 발생");
    }
}
