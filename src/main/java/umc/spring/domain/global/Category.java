package umc.spring.domain.global;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.store.Store;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(exclude = {"storeList", "memberPreferList"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;

    @Column(nullable = false, length = 100)
    String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "storeCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Store> storeList = new ArrayList<>();
}
