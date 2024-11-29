package umc.spring.domain.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.report.Report;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "report_image")
public class ReportImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    private String url;
}
