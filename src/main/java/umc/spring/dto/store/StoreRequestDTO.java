package umc.spring.dto.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.beans.ConstructorProperties;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequestDTO {
    private String name;
    private String address;
    private Long regionId; // 반드시 Long 타입이어야 하며, null 값을 허용해야 합니다.
}
