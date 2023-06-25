package kr.co.sample.dtos.common;

import kr.co.sample.constants.ResultConstant;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private String code;

    private String message;

    public static ResultDto ofSuccess() {
        return ResultDto.builder()
                .code(ResultConstant.SUCCESS_CODE)
                .message(ResultConstant.SUCCESS_MESSAGE)
                .build();
    }

    public static ResultDto ofError() {
        return ResultDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(ResultConstant.ERROR_DEFAULT_MESSAGE)
                .build();
    }

    public static ResultDto ofError(String message) {
        return ResultDto.builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(message)
                .build();
    }

    public static ResultDto ofError(String code, String message) {
        return ResultDto.builder()
                .code(code)
                .message(message)
                .build();
    }

    public boolean checkSuccess() {
        return ResultConstant.SUCCESS_CODE.equals(code);
    }

    public boolean checkError() {
        return !ResultConstant.SUCCESS_CODE.equals(code);
    }
}
