package umc.spring.repository.mission;

import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;
import umc.spring.domain.store.Store;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(MissionStatus missionStatus);
    List<Mission> dynamicQueryWithBooleanBuilder(Region region, MissionStatus missionStatus);
}
