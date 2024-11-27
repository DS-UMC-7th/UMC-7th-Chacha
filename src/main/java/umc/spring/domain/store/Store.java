package umc.spring.domain.store;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import umc.spring.domain.global.Category;
import umc.spring.domain.image.StoreImage;
import umc.spring.domain.member.Address;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;
import umc.spring.domain.review.Review;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"missions", "category"})
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @Column(nullable = false, length = 100)
    private String name;
//    @Embedded
    private String address;
    @Column(nullable = true)
    private Float score;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime openingTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime closingTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category storeCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<StoreImage> storeImages = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{id=" + storeId + ", name='" + name + "'}";
    }


}
