package kr.co.sample.dtos.common;

import kr.co.sample.constants.ResultConstant;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponseDto {

    private String code;

    private String message;

    public static ResultResponseDto ofSuccess() {
        return ResultResponseDto.builder()
                .code(ResultConstant.SUCCESS_CODE)
                .message(ResultConstant.SUCCESS_MESSAGE)
                .build();
    }

    public static ResultResponseDto ofError() {
        return ResultResponseDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(ResultConstant.ERROR_DEFAULT_MESSAGE)
                .build();
    }

    public static ResultResponseDto ofError(String message) {
        return ResultResponseDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(message)
                .build();
    }

    public static ResultResponseDto ofError(String code, String message) {
        return ResultResponseDto.builder()
                .code(code)
                .message(message)
                .build();
    }

    public boolean checkSuccess() {
        return ResultConstant.SUCCESS_MESSAGE.equals(code);
    }

    public boolean checkError() {
        return !ResultConstant.SUCCESS_MESSAGE.equals(code);
    }
}
