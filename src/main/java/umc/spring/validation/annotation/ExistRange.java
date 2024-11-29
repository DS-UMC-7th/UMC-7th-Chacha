package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.RangeExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RangeExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRange {

    String message() default "해당하는 범위가 아닙니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}