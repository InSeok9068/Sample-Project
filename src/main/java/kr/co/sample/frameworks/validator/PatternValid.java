package kr.co.sample.frameworks.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PatternValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface PatternValid {

    String DEFAULT_MESSAGE = "유효성 검증에 실패하였습니다.";
    String NUMBER_MESSAGE = "숫자만 입력가능합니다.";
    String EMAIL_MESSAGE = "올바른 이메일 주소 형식이 아닙니다.";
    String PHONE_NUMBER_MESSAGE = "올바른 전화번호 형식이 아닙니다.";
    String ENGLISH_ONLY_MESSAGE = "영어 문자만 입력 가능합니다.";
    String KOREAN_ONLY_MESSAGE = "한글 문자만 입력 가능합니다.";

    @Getter
    @AllArgsConstructor
    enum PATTERN_TYPE {
        DEFAULT("", "Default", DEFAULT_MESSAGE),
        NUMBER("^[0-9]*$", "숫자만 허용", NUMBER_MESSAGE),
        EMAIL("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", "이메일 주소", EMAIL_MESSAGE),
        PHONE_NUMBER("^\\d{3}-\\d{3,4}-\\d{4}$", "전화번호", PHONE_NUMBER_MESSAGE),
        ENGLISH_ONLY("^[A-Za-z]+$", "영어 문자만 허용", ENGLISH_ONLY_MESSAGE),
        KOREAN_ONLY("^[가-힣]+$", "한글만 허용", KOREAN_ONLY_MESSAGE);

        private final String pattern;
        private final String description;
        private final String message;
    }

    PATTERN_TYPE patternType() default PATTERN_TYPE.DEFAULT;

    String message() default DEFAULT_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
