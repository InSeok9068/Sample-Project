package kr.co.sample.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@ToString
@AllArgsConstructor
public enum TempFunctionEnum {
    TEMP_FUNCTION_1("TEMP_1", s -> s + " apply");

    private final String code;
    private final Function<String, String> expression;

    private static final Map<String, TempFunctionEnum> TEMP_FUNCTION_ENUM_MAP = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(TempFunctionEnum::getCode, e -> e)));

    public static TempFunctionEnum findByCode(String code) {
        return TEMP_FUNCTION_ENUM_MAP.get(code);
    }

    public String apply(String s) {
        return expression.apply(s);
    }
}
