package umc.spring.domain.global;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter
@MappedSuperclass  // 이 클래스는 상속받은 엔티티에서 사용할 수 있게 합니다.
@EntityListeners(AuditingEntityListener.class)  // JPA Auditing 기능을 사용하도록 설정
public class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;  // 생성된 시간

    @LastModifiedDate
    private LocalDateTime updatedAt;  // 마지막 수정된 시간

    // Getters and Setters
}