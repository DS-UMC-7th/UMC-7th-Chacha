package umc.spring.dto.mission;

import lombok.*;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.region.Region;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MissionResponseDTO {

    private Long id;
    private String title;
    private Integer point;
    private String bond;
    private LocalDate deadline;
    private String missionSpec;
    private MissionStatus status;
    private StoreDTO store;
    private RegionDTO region;

    // DTO 내부 클래스: StoreDTO
    @Getter
    @AllArgsConstructor
    public static class StoreDTO {
        private Long id;
        private String name;
    }

    // DTO 내부 클래스: RegionDTO
    @Getter
    @AllArgsConstructor
    public static class RegionDTO {
        private Long id;
        private String name;
    }

    // Factory method to convert Mission to MissionResponseDTO
    public static MissionResponseDTO fromMission(umc.spring.domain.mission.Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getTitle(),
                mission.getPoint(),
                mission.getBond(),
                mission.getDeadline(),
                mission.getMissionSpec(),
                mission.getStatus(),
                new StoreDTO(mission.getStore().getStoreId(), mission.getStore().getName()),
                new RegionDTO(mission.getRegion().getRegion_id(), mission.getRegion().getCity())
        );
    }
}
