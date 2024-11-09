package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;
import umc.spring.repository.mission.MissionRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl {
    private final MissionRepository missionRepository;

    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }
    public List<Mission> findMissionsByStatus(MissionStatus missionStatus) {
        List<Mission> filterMissions = missionRepository.dynamicQueryWithBooleanBuilder(MissionStatus.CHALLENGING);
        filterMissions.forEach(mission -> System.out.println("Mission: " + mission));
        return filterMissions;

    }public List<Mission> findMissionsByRegionAndStatus(Region region, MissionStatus missionStatus) {
        List<Mission> filterMissions = missionRepository.dynamicQueryWithBooleanBuilder(region, missionStatus);
        filterMissions.forEach(mission -> System.out.println("Region: " + region + ", Mission: " + mission));
        return filterMissions;

    }

}

