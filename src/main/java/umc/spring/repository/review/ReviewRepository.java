package umc.spring.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.member.Member;
import umc.spring.domain.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByMember_memberId(Long memberId, Pageable pageable);
}
