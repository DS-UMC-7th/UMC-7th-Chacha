package umc.spring.repository.mission;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mission.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}