package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.sample.dtos.TempDto;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.frameworks.validator.PatternValid;
import kr.co.sample.services.TempService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "99-1. 임시")
@RequestMapping(value = "/temp", produces = MediaType.APPLICATION_JSON_VALUE)
public class TempController {

    private final TempService tempService;

    @Operation(summary = "임시 리스트 조회")
    @GetMapping(value = "/list")
    ResultGenericDto<List<TempDto>> getTempList() {
        return tempService.getTempList();
    }

    @Operation(summary = "임시 조회")
    @GetMapping()
    ResultGenericDto<TempDto> getTemp(@RequestParam @PatternValid(patternType = PatternValid.PATTERN_TYPE.NUMBER) String id) {
        return tempService.getTemp(Long.valueOf(id));
    }

    @Operation(summary = "임시 생성")
    @PostMapping()
    ResultDto createTemp(@Valid @RequestBody TempDto tempDto) {
        return tempService.createTemp(tempDto);
    }

    @Operation(summary = "임시 조회(JPA Query)")
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
