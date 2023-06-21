package kr.co.sample.common;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    @Builder.Default
    int code = 0;

    @Builder.Default
    String message = StringUtils.EMPTY;

    public static BaseResponse ofSuccess() {
        return BaseResponse.builder().build();
    }

    public static BaseResponse ofError() {
        return BaseResponse.builder()
                .code(9999)
                .message("실패")
                .build();
    }
}
