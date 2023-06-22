package kr.co.sample.dtos.common;

import kr.co.sample.constants.ResultConstant;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultGenericResponseDto<T> {

    private String code;

    private String message;

    private T data;

    public static <T> ResultGenericResponseDto<T> ofSuccess() {
        return ResultGenericResponseDto.<T>builder()
                .code(ResultConstant.SUCCESS_CODE)
                .message(ResultConstant.SUCCESS_MESSAGE)
                .build();
    }

    public static <T> ResultGenericResponseDto<T> ofSuccess(T data) {
        return ResultGenericResponseDto.<T>builder()
                .code(ResultConstant.SUCCESS_CODE)
                .message(ResultConstant.SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    public static <T> ResultGenericResponseDto<T> ofError() {
        return ResultGenericResponseDto.<T>builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(ResultConstant.ERROR_DEFAULT_MESSAGE)
                .build();
    }

    public static <T> ResultGenericResponseDto<T> ofError(String code, String message) {
        return ResultGenericResponseDto.<T>builder()
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
