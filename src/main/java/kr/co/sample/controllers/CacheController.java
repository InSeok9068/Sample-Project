package kr.co.sample.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.services.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-2. 캐싱")
@RequestMapping(value = "/example/cache", produces = MediaType.APPLICATION_JSON_VALUE)
public class CacheController {

    private final CacheService cacheService;

    @Operation(summary = "캐싱 데이터 조회")
    @GetMapping(value = "/get")
    ResultGenericDto<String> getData(String key) {
        return cacheService.getData(key);
    }

    @Operation(summary = "캐싱 데이터 등록")
    @PostMapping(value = "/add")
    ResultDto addData(String key, String data) {
        return cacheService.addData(key, data);
    }

    @Operation(summary = "캐싱 데이터 삭제")
    @DeleteMapping(value = "/remove")
    ResultDto removeData(String key) {
        return cacheService.removeData(key);
    }

    @Operation(summary = "캐싱 데이터 등록 실패 (DB + Redis) - 트랜잭션")
    @PostMapping(value = "/add-fail")
    ResultDto transactionDbAndRedis(Long id) {
        return cacheService.transactionDbAndRedis(id);
    }
}
