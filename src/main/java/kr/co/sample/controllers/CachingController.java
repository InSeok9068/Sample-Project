package kr.co.sample.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.services.CachingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-2. 캐싱")
@RequestMapping(value = "/example/caching", produces = MediaType.APPLICATION_JSON_VALUE)
public class CachingController {

    private final CachingService cachingService;

    @Operation(summary = "캐싱 데이터 조회")
    @GetMapping(value = "/get")
    ResultGenericDto<String> getData(String key) {
        return cachingService.getData(key);
    }

    @Operation(summary = "캐싱 데이터 등록")
    @PostMapping(value = "/add")
    ResultDto addData(String key, String data) {
        return cachingService.addData(key, data);
    }

    @Operation(summary = "캐싱 데이터 삭제")
    @DeleteMapping(value = "/remove")
    ResultDto removeData(String key) {
        return cachingService.removeData(key);
    }
}
