package umc.spring.converter;

import jakarta.persistence.Converter;
import umc.spring.domain.review.Review;
import umc.spring.dto.mission.MyReveiwDTO;

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
}
