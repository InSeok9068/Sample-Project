package kr.co.sample.exceptions;

import kr.co.sample.constants.ResultConstant;
import kr.co.sample.dtos.common.ResultResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResultResponseDto globalExceptionHanlder(Exception e) {
        log.error("Global Exception : {}", ExceptionUtils.getStackTrace(e));
        return ResultResponseDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(ResultConstant.ERROR_DEFAULT_MESSAGE)
                .build();
    }
}
