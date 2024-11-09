package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.review.Review;
import umc.spring.repository.review.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl {
    private final ReviewRepository reviewRepository;

    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        Review createdReview = reviewRepository.save(review);
        return createdReview;

    }
}
