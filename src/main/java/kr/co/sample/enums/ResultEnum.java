package kr.co.sample.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum ResultEnum {
    SUCCESS("0", "SUCCESS"),
    ERROR("9999", "ERROR");

    private final String code;
    private final String message;
}
