package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.services.ApiRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-8. API 요청")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRequestController {

    private final ApiRequestService apiRequestService;

    @Operation(summary = "유저 조회 API 요청 (RestTemplate)")
    @GetMapping("/users/{id}/rest-template")
    ResultGenericDto<Map<String, Object>> getUserByRestTemplate(@PathVariable int id) {
        return apiRequestService.getUserByRestTemplate(id);
    }

    @Operation(summary = "유저 조회 API 요청 (WebClinet)")
    @GetMapping("/users/{id}/web-client")
    ResultGenericDto<Map<String, Object>> getUserByWebClient(@PathVariable int id) {
        return apiRequestService.getUserByWebClient(id);
    }
}
