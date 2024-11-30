package umc.spring.controller.mission;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.region.Region;
import umc.spring.dto.mission.MissionResponseDTO;
import umc.spring.service.RegionQueryService;
import umc.spring.service.mission.MissionQueryServiceImpl;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistRange;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Slf4j
@Validated
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
    // 특정 가게의 미션 목록
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<ApiResponse<?>>  findMissionByStore(
            @RequestParam(name = "storeId") @NotNull(message = "값은 필수입니다.") @ExistStores Long storeId,
            @RequestParam(defaultValue = "0", name = "page")  @ExistRange int page,  // 기본 0
            @RequestParam(defaultValue = "10", name = "size") int size  // 10개씩
    ) {
        return ResponseEntity.ok(ApiResponse.onSuccess(missionQueryService.getAllMissionsByStore(storeId, page -1, size)));
    }
    @GetMapping("/myMission")
    @ResponseBody
    @Validated
    public ResponseEntity<ApiResponse<?>>  findMissionsBymemberId(
            @RequestParam(name = "memberId") @NotNull(message = "값은 필수입니다.") Long memberId,
            @RequestParam(defaultValue = "0", name = "page")  @ExistRange int page,  // 기본 0
            @RequestParam(defaultValue = "10", name = "size") int size  // 10개씩
    ) {
        return ResponseEntity.ok(ApiResponse.onSuccess(missionQueryService.getAllMissionsByMemberId(memberId, page -1, size)));
    }


}