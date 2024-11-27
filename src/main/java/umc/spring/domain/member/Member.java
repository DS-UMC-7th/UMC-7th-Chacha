package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.image.ProfileImage;
import umc.spring.domain.mapping.MemberAlarm;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.report.Report;
import umc.spring.domain.review.Review;

import java.util.List;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = true, length = 100)
    private String birthDay;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
//    @Embedded
    private String address;
    @Column(nullable = true)
    private Integer level;
    @Column(nullable = true)
    private Integer point;
    @Column(nullable = true, length = 100)
    private String email;
    @Column(unique = true, length = 100)
    String nickname;
    @Column(nullable = true, length = 100)
    String phoneNumber;
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProfileImage profileImage;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberAlarm> memberAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Report> reportList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
