package umc.spring.domain.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String birthDay;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Embedded
    private Address address;
    @Column(nullable = false)
    private Integer level;
    @Column(nullable = false)
    private Integer point;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(unique = true, length = 100)
    String nickname;
    @Column(nullable = false, length = 100)
    String phoneNumber;
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private ProfileImage profileImage;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAlarm> memberAlarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Report> reportList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
