package umc.spring.domain.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import umc.spring.domain.review.Review;
import umc.spring.domain.store.Store;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "store_image")
public class StoreImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_image")
    private Store store;

    private String url;
}