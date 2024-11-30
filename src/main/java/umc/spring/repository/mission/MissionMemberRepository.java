package umc.spring.repository.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mission.Mission;

public interface MissionMemberRepository extends JpaRepository<MemberMission, Long>, MissionMemberCustom{

    boolean existsMemberMissionByMember_MemberIdAndMission_Id(Long memberId, Long missionId);
    @Query("SELECT mm.mission FROM MemberMission mm WHERE mm.member.memberId = :memberId and mm.status = 'CHALLENGING'")
    Page<Mission> findMemberMissionsByMember_MemberId(@Param("memberId") Long memberId, PageRequest pageable);


}
