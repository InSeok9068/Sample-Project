package kr.co.sample.exceptions;

import kr.co.sample.constants.ResultConstant;
import kr.co.sample.dtos.common.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResultDto globalExceptionHanlder(Exception e) {
        log.error("Global Exception : {}", ExceptionUtils.getStackTrace(e));
        return ResultDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(ResultConstant.ERROR_DEFAULT_MESSAGE)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResultDto globalExceptionHanlder(MethodArgumentNotValidException e) {
        log.error("Global Exception : {}", ExceptionUtils.getStackTrace(e));
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        bindingResult.getAllErrors().forEach(error -> sb.append(error.getDefaultMessage()).append(" "));
        return ResultDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(sb.toString())
                .build();
    }
}
