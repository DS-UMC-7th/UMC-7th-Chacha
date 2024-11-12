package umc.spring.controller.mission;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;
import umc.spring.service.RegionQueryService;
import umc.spring.service.mission.MissionQueryServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Slf4j
public class MissionController {

    private final MissionQueryServiceImpl missionQueryService;
    private final RegionQueryService regionQueryService;

    // 지역 ID와 미션 상태를 받아 미션 목록을 반환하는 API
    @GetMapping("/region-and-status")
    public ResponseEntity<List<Mission>> getMissionsByRegionAndStatus(
            @RequestParam(name = "regionId") Long regionId,
            @RequestParam(name = "missionStatus") MissionStatus missionStatus) {

        Region region = regionQueryService.findRegionById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid region ID"));
        // 로그 추가
        log.info("Received regionId: {}", regionId);
        log.info("Received missionStatus: {}", missionStatus);

        List<Mission> missions = missionQueryService.findMissionsByRegionAndStatus(region, missionStatus);
        return ResponseEntity.ok(missions);
    }

}