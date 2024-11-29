package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.validation.annotation.ExistRange;
import umc.spring.validation.annotation.ExistReveiws;

@Component
@RequiredArgsConstructor
public class RangeExistValidator implements ConstraintValidator<ExistRange, Integer> {

    @Override
    public void initialize(ExistRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 0) {  // 값이 null이거나 0 미만이면 유효하지 않음
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RANGE_NOT_ALLOWED.toString())
                    .addConstraintViolation();
            return false;  // 유효하지 않음
        }
        return true;  // 유효함
    }

}
