package kr.co.sample.dtos.common;

import kr.co.sample.enums.ResultEnum;
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
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .build();
    }

    public static <T> ResultGenericDto<T> ofSuccess(T data) {
        return ResultGenericDto.<T>builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> ResultGenericDto<T> ofError() {
        return ResultGenericDto.<T>builder()
                .code(ResultEnum.ERROR.getCode())
                .message(ResultEnum.ERROR.getMessage())
                .build();
    }

    public static <T> ResultGenericDto<T> ofError(String message) {
        return ResultGenericDto.<T>builder()
                .code(ResultEnum.ERROR.getCode())
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
        return ResultEnum.SUCCESS.getCode().equals(code);
    }

    public boolean checkError() {
        return !ResultEnum.SUCCESS.getCode().equals(code);
    }
}
