package umc.spring.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.image.ReviewImage;
import umc.spring.domain.mapping.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MyReveiwDTO {
    private Long id;
    private String memberNickname;
    private Integer star;
    private String content;
    private LocalDateTime createdAt;
    private List<ReviewImage> reviewImageList = new ArrayList<>();

//    private MissionResponseDTO.StoreDTO store;
//    private MissionResponseDTO.RegionDTO region;

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
}
