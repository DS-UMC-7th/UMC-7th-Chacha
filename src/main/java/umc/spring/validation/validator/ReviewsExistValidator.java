package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistReveiws;

@Component
@RequiredArgsConstructor
public class ReviewsExistValidator implements ConstraintValidator<ExistReveiws, Long> {
    private final ReviewRepository reviewRepository;


    @Override
    public void initialize(ExistReveiws constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = reviewRepository.existsById(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_NOT_FOUND.toString()).addConstraintViolation();
        }
        return reviewRepository.existsById(value);
    }
}
