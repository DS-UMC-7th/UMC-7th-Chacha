package umc.spring.domain.store;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import umc.spring.domain.global.Category;
import umc.spring.domain.image.StoreImage;
import umc.spring.domain.member.Address;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.review.Review;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @Column(nullable = false, length = 100)
    private String name;
    @Embedded
    private Address address;
    @Column(nullable = false)
    private Integer star;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime openingTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime closingTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category storeCategory;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    List<StoreImage> storeImages = new ArrayList<>();


}
