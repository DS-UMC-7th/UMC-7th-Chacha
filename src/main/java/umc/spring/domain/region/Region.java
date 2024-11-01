package umc.spring.domain.region;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.global.Category;
import umc.spring.domain.member.Address;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.Mission;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long region_id;
    @Embedded
    private Address address;
    @Column(nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
