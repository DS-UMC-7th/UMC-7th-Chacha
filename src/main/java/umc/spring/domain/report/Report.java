package umc.spring.domain.report;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.global.BaseEntity;
import umc.spring.domain.image.ReportImage;
import umc.spring.domain.member.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "report")
public class Report extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Enumerated(EnumType.STRING)
    private ReportStatus status;
    @Column(nullable = false, length = 100)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<ReportImage> reportImages = new ArrayList<>();

}
