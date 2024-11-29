package umc.spring.domain.mapping;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.global.Category;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.Mission;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(exclude = {"mission", "member"})
@Table(name = "member_mission")
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberMissionList().remove(this);
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission){
        if(this.mission != null)
            mission.getMemberMissionList().remove(this);
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }
}