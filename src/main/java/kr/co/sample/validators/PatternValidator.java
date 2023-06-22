package kr.co.sample.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.co.sample.validators.PatternValid.PATTERN_TYPE;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class PatternValidator implements ConstraintValidator<PatternValid, CharSequence> {
    private PATTERN_TYPE patternType;

    @Override
    public void initialize(PatternValid patternValid) {
        this.patternType = patternValid.patternType();
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(charSequence)) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(patternType.getMessage()).addConstraintViolation();

        return Pattern.matches(patternType.getPattern(), charSequence);
    }
}
