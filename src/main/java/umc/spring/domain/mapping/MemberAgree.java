package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.member.Member;
import umc.spring.domain.member.Terms;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member_agree")
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;
}