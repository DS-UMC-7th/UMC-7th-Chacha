package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.mission.MissionMemberRepository;
import umc.spring.repository.mission.MissionMemberRepositoryImpl;
import umc.spring.repository.mission.MissionRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl {
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MissionMemberRepository missionMemberRepository;

    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }
    public List<Mission> findMissionsByStatus(MissionStatus missionStatus) {
        List<Mission> filterMissions = missionRepository.dynamicQueryWithBooleanBuilder(MissionStatus.CHALLENGING);
        filterMissions.forEach(mission -> System.out.println("Mission: " + mission));
        return filterMissions;

    }
//    public List<Mission> findMissionsByRegionAndStatus(Region region, MissionStatus missionStatus) {
//        List<Mission> filterMissions = missionRepository.dynamicQueryWithBooleanBuilder(region, missionStatus);
//        filterMissions.forEach(mission -> System.out.println("Region: " + region + ", Mission: " + mission));
//        return filterMissions;
//
//    }
    @Transactional
    public List<Mission> findMissionsByRegionAndStatus(Region region, MissionStatus missionStatus) {
        // 이 메서드에서 트랜잭션을 유지하여 연관된 missionList 컬렉션을 로딩
        List<Mission> filterMissions = missionRepository.dynamicQueryWithBooleanBuilder(region, missionStatus);
        filterMissions.forEach(mission -> System.out.println("Region: " + region + ", Mission: " + mission));
        return filterMissions;
    }
//    @Transactional
//    public List<Mission> findMissionsByMember(Long memberId) {
//        // 이 메서드에서 트랜잭션을 유지하여 연관된 missionList 컬렉션을 로딩
//        List<Mission> filterMissions = missionRepository.fi
//
//        return filterMissions;
//    }

    @Transactional
    public String challengeMission(Long memberId, Long missionId) {
        // 1. 회원 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));

        // 2. 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid mission ID"));

        // 3. 미션 상태를 CHALLENGING으로 설정
        mission.setStatus(MissionStatus.CHALLENGING);

        // 4. 미션 저장 (상태 업데이트)
        missionRepository.save(mission);

        // 5. MissionMember 엔티티 생성하여 mission_member 테이블에 추가
        MemberMission missionMember = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        missionMemberRepository.save(missionMember);

        return "Mission added to the member's challenges!";
    }



}

