package umc.spring.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
