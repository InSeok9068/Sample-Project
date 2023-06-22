package kr.co.sample.dtos.common;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto {

    @Builder.Default
    int code = 0;

    @Builder.Default
    String message = StringUtils.EMPTY;

    public static BaseResponseDto ofSuccess() {
        return BaseResponseDto.builder().build();
    }

    public static BaseResponseDto ofError() {
        return BaseResponseDto.builder()
                .code(9999)
                .message("실패")
                .build();
    }
}
