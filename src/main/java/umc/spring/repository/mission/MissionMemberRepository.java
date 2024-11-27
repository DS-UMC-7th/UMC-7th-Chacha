package umc.spring.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mission.Mission;

import java.util.List;

public interface MissionMemberRepository extends JpaRepository<MemberMission, Long>, MissionMemberCustom{

}
