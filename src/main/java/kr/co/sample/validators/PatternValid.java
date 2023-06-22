package kr.co.sample.validators;

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

    String NUMBER_MESSAGE = "숫자만 입력가능합니다.";

    @Getter
    @AllArgsConstructor
    enum PATTERN_TYPE {

        NUMBER("^[0-9]*$", "숫자만 허용", NUMBER_MESSAGE);

        private final String pattern;
        private final String description;
        private final String message;
    }

    PATTERN_TYPE patternType() default PATTERN_TYPE.NUMBER;

    String message() default NUMBER_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
