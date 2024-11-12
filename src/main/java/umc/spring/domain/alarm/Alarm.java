package umc.spring.domain.alarm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.MemberAlarm;
import umc.spring.domain.member.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "alarm")
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;

    @Enumerated(value = EnumType.STRING)
    private AlarmType alarmType;
    @JsonManagedReference
    @OneToMany(mappedBy = "alarm", cascade = CascadeType.ALL)
    private List<MemberAlarm> memberAlarmList = new ArrayList<>();
}
