package kr.co.sample.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum TempEnum {
    TEMP_1("TEMP_1", "TEMP_1");

    private final String code;
    private final String desc;
}
