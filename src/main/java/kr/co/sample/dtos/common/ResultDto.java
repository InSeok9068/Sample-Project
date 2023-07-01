package kr.co.sample.dtos.common;

import kr.co.sample.enums.ResultEnum;
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
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .build();
    }

    public static ResultDto ofError() {
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
                .message(ResultEnum.ERROR.getMessage())
                .build();
    }

    public static ResultDto ofError(String message) {
        return ResultDto.builder()
                .code(ResultEnum.ERROR.getCode())
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
        return ResultEnum.SUCCESS.getCode().equals(code);
    }

    public boolean checkError() {
        return !ResultEnum.SUCCESS.getCode().equals(code);
    }
}
