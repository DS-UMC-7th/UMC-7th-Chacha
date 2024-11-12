package umc.spring.domain.mission;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.global.Category;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.region.Region;
import umc.spring.domain.store.Store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"store", "memberMissionList"})
@Table(name = "mission")
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private Integer point;
    @Column(nullable = false, length = 100)
    private String bond;
    @Column(nullable = false)
    private LocalDate deadline;
    @Column(nullable = false, length = 100)
    private String missionSpec;
    @Enumerated(EnumType.STRING)
    private MissionStatus status = MissionStatus.CHALLENGING; // 기본값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category storeCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;
    @JsonManagedReference
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
