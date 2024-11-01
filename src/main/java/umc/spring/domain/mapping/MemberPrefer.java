package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.global.Category;
import umc.spring.domain.member.Member;

@Entity
@Getter
@Builder
@NoArgsConstructor()
@AllArgsConstructor@Table(name = "member_prefer")
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category foodCategory;

}