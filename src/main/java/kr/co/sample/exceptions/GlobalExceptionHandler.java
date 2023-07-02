package kr.co.sample.exceptions;

import jakarta.validation.ConstraintViolationException;
import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.enums.ResultEnum;
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
    private ResultDto exceptionHandler(Exception e) {
        log.error("Exception : {}", ExceptionUtils.getStackTrace(e));
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
                .message(ResultEnum.ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResultDto methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException Exception : {}", ExceptionUtils.getStackTrace(e));
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        bindingResult.getAllErrors().forEach(error -> sb.append(error.getDefaultMessage()).append(" "));
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
                .message(sb.toString())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResultDto constraintViolationExceptionHandler(ConstraintViolationException e) {
        log.error("MethodArgumentNotValidException Exception : {}", ExceptionUtils.getStackTrace(e));
        StringBuilder sb = new StringBuilder();
        e.getConstraintViolations().forEach(constraintViolation -> sb.append(constraintViolation.getMessage()).append(" "));
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
                .message(sb.toString())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResultDto illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("IllegalArgumentException : {}", ExceptionUtils.getStackTrace(e));
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(IllegalStateException.class)
    private ResultDto illegalStateExceptionHandler(IllegalStateException e) {
        log.error("IllegalStateException : {}", ExceptionUtils.getStackTrace(e));
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
                .message(e.getMessage())
                .build();
    }
}
