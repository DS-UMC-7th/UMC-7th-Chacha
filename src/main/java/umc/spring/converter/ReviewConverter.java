package umc.spring.converter;

import jakarta.persistence.Converter;
import umc.spring.domain.image.ReviewImage;
import umc.spring.domain.review.Review;
import umc.spring.domain.store.Store;
import umc.spring.dto.mission.MyReveiwDTO;
import umc.spring.dto.review.ReviewRequestDTO;

import java.util.List;

public class ReviewConverter {

    public static MyReveiwDTO convertReviewList(Review review) {
        return MyReveiwDTO.builder()
                .id(review.getReviewId())
                .star(review.getStar())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .memberNickname(review.getMember().getNickname())
                .reviewImageList(review.getReviewImageList())
                .build();
    }
    public static Review convertReveiw(ReviewRequestDTO dto, Store store, List<ReviewImage> image) {
        return Review.builder()
                .content(dto.getContent())
                .star(dto.getStar())
                .comment(dto.getComment())
                .store(store)
                .reviewImageList(image)
                .build();
    }
}