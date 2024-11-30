package umc.spring.dto.mission;

import lombok.*;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;

import java.time.LocalDate;

@Getter@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MissionResponseDTO {

     Long id;
     String title;
     Integer point;
     String bond;
     LocalDate deadline;
     String missionSpec;
//     MissionStatus status;
     StoreDTO store;
     RegionDTO region;

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
    public static MissionResponseDTO fromMission(Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getTitle(),
                mission.getPoint(),
                mission.getBond(),
                mission.getDeadline(),
                mission.getMissionSpec(),
//                mission.getStatus(),
                new StoreDTO(mission.getStore().getStoreId(), mission.getStore().getName()),
                new RegionDTO(mission.getRegion().getRegion_id(), mission.getRegion().getCity())
        );
    }
}
