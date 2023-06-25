package kr.co.sample.dtos.common;

import kr.co.sample.constants.ResultConstant;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultGenericDto<T> {

    private String code;

    private String message;

    private T data;

    public static <T> ResultGenericDto<T> ofSuccess() {
        return ResultGenericDto.<T>builder()
                .code(ResultConstant.SUCCESS_CODE)
                .message(ResultConstant.SUCCESS_MESSAGE)
                .build();
    }

    public static <T> ResultGenericDto<T> ofSuccess(T data) {
        return ResultGenericDto.<T>builder()
                .code(ResultConstant.SUCCESS_CODE)
                .message(ResultConstant.SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    public static <T> ResultGenericDto<T> ofError() {
        return ResultGenericDto.<T>builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(ResultConstant.ERROR_DEFAULT_MESSAGE)
                .build();
    }

    public static <T> ResultGenericDto<T> ofError(String message) {
        return ResultGenericDto.<T>builder()
                .code(ResultConstant.ERROR_DEFAULT_CODE)
                .message(message)
                .build();
    }

    public static <T> ResultGenericDto<T> ofError(String code, String message) {
        return ResultGenericDto.<T>builder()
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
