package umc.spring.domain.alarm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum AlarmType {
    EVENT, REVIEW, REPORT
}
