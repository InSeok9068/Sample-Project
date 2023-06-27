package kr.co.sample.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.services.EventDrivenPubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "99-6. 이벤트 기반")
@RequestMapping(value = "/event/driven", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventDrivenController {

    private final EventDrivenPubService eventDrivenPubService;

    @Operation(summary = "이벤트 발행")
    @PostMapping()
    ResultDto publishEvent() {
        eventDrivenPubService.publishEvent();
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "이벤트 발행(비동기)")
    @PostMapping(value = "/async")
    ResultDto publishEventAsync() {
        eventDrivenPubService.publishEventAsync();
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "이벤트 발행(트랜잭션)")
    @PostMapping(value = "/transaction")
    ResultDto publishEventTransaction() {
        eventDrivenPubService.publishEventTransaction();
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "이벤트 발행(트랜잭션-Case1)")
    @PostMapping(value = "/transaction/case1")
    ResultDto publishEventTransactionCase1() {
        eventDrivenPubService.publishEventTransactionCase1();
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "이벤트 발행(트랜잭션-Case2)")
    @PostMapping(value = "/transaction/case2")
    ResultDto publishEventTransactionCase2() {
        eventDrivenPubService.publishEventTransactionCase2();
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "이벤트 발행(트랜잭션-Case3)")
    @PostMapping(value = "/transaction/case3")
    ResultDto publishEventTransactionCase3() {
        eventDrivenPubService.publishEventTransactionCase3();
        return ResultDto.ofSuccess();
    }

    @Operation(summary = "이벤트 발행(트랜잭션-Case4)")
    @PostMapping(value = "/transaction/case4")
    ResultDto publishEventTransactionCase4() {
        eventDrivenPubService.publishEventTransactionCase4();
        return ResultDto.ofSuccess();
    }
}
