package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.mission.MissionMemberRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.validation.annotation.ExistMissions;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MssionsExistValidator implements ConstraintValidator<ExistMissions, Long> {
    private final MissionRepository missionRepository;
    private final MissionMemberRepository missionMemberRepository;


    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionRepository.existsById(value);
        Mission mission = missionRepository.findById(value).get();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        // 이미 도전 중인지 확인 (예: 로그인 사용자 ID는 1L로 가정)
        Long memberId = 1L; // 실제로는 SecurityContextHolder에서 가져옴
        if(!missionMemberRepository.existsMemberMissionByMember_MemberIdAndMission_Id(memberId, mission.getId())){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return missionRepository.existsById(value);
    }
}
