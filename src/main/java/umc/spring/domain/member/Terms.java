package umc.spring.domain.member;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.*;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.mapping.MemberAgree;

import java.util.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private Boolean optional;
    @JsonManagedReference
    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}