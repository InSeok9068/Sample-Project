package kr.co.sample.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultGenericResponseDto;
import kr.co.sample.dtos.common.ResultResponseDto;
import kr.co.sample.services.CachingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "2. 캐싱")
@RequestMapping(value = "/example/caching", produces = MediaType.APPLICATION_JSON_VALUE)
public class CachingController {

    private final CachingService cachingService;

    @Operation(summary = "캐싱 데이터 조회")
    @GetMapping(value = "/get")
    ResultGenericResponseDto<String> getData(String key) {
        return cachingService.getData(key);
    }

    @Operation(summary = "캐싱 데이터 등록")
    @PostMapping(value = "/add")
    ResultResponseDto addData(String key, String data) {
        return cachingService.addData(key, data);
    }

    @Operation(summary = "캐싱 데이터 삭제")
    @DeleteMapping(value = "/remove")
    ResultResponseDto removeData(String key) {
        return cachingService.removeData(key);
    }
}
