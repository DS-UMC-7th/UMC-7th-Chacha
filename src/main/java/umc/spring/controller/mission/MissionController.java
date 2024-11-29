package umc.spring.controller.mission;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;
import umc.spring.dto.mission.MissionResponseDTO;
import umc.spring.service.RegionQueryService;
import umc.spring.service.mission.MissionQueryServiceImpl;
import umc.spring.validation.annotation.ExistMissions;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Slf4j
public class MissionController {

    private final MissionQueryServiceImpl missionQueryService;
    private final RegionQueryService regionQueryService;

    // 지역 ID와 미션 상태를 받아 미션 목록을 반환하는 API
    @GetMapping("/region-and-status")
    public ResponseEntity<List<MissionResponseDTO>> getMissionsByRegionAndStatus(
            @RequestParam(name = "regionId") Long regionId,
            @RequestParam(name = "missionStatus") MissionStatus missionStatus) {

        Region region = regionQueryService.findRegionById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid region ID"));
        // 로그 추가
        log.info("Received regionId: {}", regionId);
        log.info("Received missionStatus: {}", missionStatus);

        List<MissionResponseDTO> missionResponseDTOs = missionQueryService.findMissionsByRegionAndStatus(region, missionStatus)
                .stream()
                .map(MissionResponseDTO::fromMission)  // fromMission 메서드를 사용하여 변환
                .collect(Collectors.toList());

        return ResponseEntity.ok(missionResponseDTOs);
    }
    @PostMapping("/challenge")
    @Validated
    public ResponseEntity<ApiResponse<String>> challengeMission(@RequestParam(name = "memberId") Long memberId,
                                                        @ExistMissions @RequestParam(name = "missionId") Long missionId) {
        String response = missionQueryService.challengeMission(memberId, missionId);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }


}