package umc.spring.domain.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.global.Category;
import umc.spring.domain.image.ReviewImage;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.member.Member;
import umc.spring.domain.store.Store;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @Column(nullable = false, length = 100)
    private String content;
    @Column(nullable = false)
    private Integer star;
    @Column(nullable = false, length = 100)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();




}
