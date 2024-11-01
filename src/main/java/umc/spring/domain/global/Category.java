package umc.spring.domain.global;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.store.Store;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;
    @Column(nullable = false, length = 100)
    String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "storeCategory", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();




}
