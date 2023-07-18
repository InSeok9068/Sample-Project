package kr.co.sample.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodeMap {

    @Getter
    @RequiredArgsConstructor
    public enum ACTION_TYPE {
        ACTION_1("ACTION_1", "액션 1"),
        ACTION_2("ACTION_2", "액션 2"),
        ACTION_3("ACTION_3", "액션 3");

        private final String code;
        private final String desc;

        private static final Map<String, ACTION_TYPE> ACTION_TYPE_MAP = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(ACTION_TYPE::getCode, e -> e)));

        public static ACTION_TYPE findByCode(String code) {
            return ACTION_TYPE_MAP.get(code);
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum OPTION_TYPE {
        OPTION_1("OPTION_1", "옵션 1"),
        OPTION_2("OPTION_2", "옵션 2"),
        OPTION_3("OPTION_3", "옵션 3");

        private final String code;
        private final String desc;

        private static final Map<String, OPTION_TYPE> OPTION_TYPE_MAP = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(OPTION_TYPE::getCode, e -> e)));

        public static OPTION_TYPE findByCode(String code) {
            return OPTION_TYPE_MAP.get(code);
        }
    }
}
