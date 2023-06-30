package kr.co.sample.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@ToString
@RequiredArgsConstructor
public enum TempEnum {
    TEMP_1("TEMP_1", "TEMP_1");

    private final String code;
    private final String desc;

    private static final Map<String, TempEnum> TEMP_ENUM_MAP = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(TempEnum::getCode, e -> e)));

    public static TempEnum findByCode(String code) {
        return TEMP_ENUM_MAP.get(code);
    }
}
