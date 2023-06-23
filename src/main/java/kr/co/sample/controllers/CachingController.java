package kr.co.sample.controllers;


import kr.co.sample.dtos.common.ResultGenericResponseDto;
import kr.co.sample.dtos.common.ResultResponseDto;
import kr.co.sample.services.CachingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/example/caching", produces = MediaType.APPLICATION_JSON_VALUE)
public class CachingController {

    private final CachingService cachingService;

    @GetMapping(value = "/get")
    ResultGenericResponseDto<String> getData(String key) {
        return cachingService.getData(key);
    }

    @PostMapping(value = "/add")
    ResultResponseDto addData(String key, String data) {
        return cachingService.addData(key, data);
    }

    @DeleteMapping(value = "/remove")
    ResultResponseDto removeData(String key) {
        return cachingService.removeData(key);
    }
}
