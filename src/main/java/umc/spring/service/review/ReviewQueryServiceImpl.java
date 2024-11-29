package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.image.ReviewImage;
import umc.spring.domain.member.Member;
import umc.spring.domain.review.Review;
import umc.spring.dto.mission.MyReveiwDTO;
import umc.spring.dto.review.ReviewRequestDTO;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        Review createdReview = reviewRepository.save(review);
        return createdReview;

    }
    public Page<MyReveiwDTO> findMyReviewList(Long memberId, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);  // 페이지 번호와 크기를 기반으로 Pageable 객체 생성

        Page<Review> reviewPage = reviewRepository.findByMember_memberId(memberId, pageable); // 페이징된 리뷰 조회

        return reviewPage.map(ReviewConverter::convertReviewList);  // Review를 MyReveiwDTO로 변환
    }
    public void createReview(ReviewRequestDTO requestDTO) {
        List<ReviewImage> images = requestDTO.getImageUrls().stream().map(url -> {
            ReviewImage reviewImage = new ReviewImage();
            reviewImage.setUrl(url);
            return  reviewImage;
        }).collect(Collectors.toList());

//        Review review = ReviewConverter.convertReveiw(requestDTO, storeRepository.findById(requestDTO.getStoreId()).orElseThrow(()->new StoreHandler(ErrorStatus.STORE_NOT_FOUND)), images);
        Review review = ReviewConverter.convertReveiw(requestDTO, storeRepository.findById(requestDTO.getStoreId()).get(), images);

        images.forEach(image -> image.setReview(review));
        reviewRepository.save(review);


    }


}
