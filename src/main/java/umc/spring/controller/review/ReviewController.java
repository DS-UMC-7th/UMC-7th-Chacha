package umc.spring.controller.review;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.member.Member;
import umc.spring.dto.mission.MyReveiwDTO;
import umc.spring.dto.review.ReviewRequestDTO;
import umc.spring.service.review.ReviewQueryServiceImpl;
import umc.spring.validation.annotation.ExistRange;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    final ReviewQueryServiceImpl reviewService;

    @GetMapping
    @Validated
    public Page<MyReveiwDTO> getReviews(
            @RequestParam(name = "memberId") Long memberId,
            @RequestParam(defaultValue = "0", name = "page") @ExistRange int page,  // 기본 0
            @RequestParam(defaultValue = "10", name = "size") int size  // 10개씩
    ) {
        return reviewService.findMyReviewList(memberId, page -1 , size);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<String>> createReview( @RequestBody @Valid ReviewRequestDTO reviewRequestDTO) {
        reviewService.createReview(reviewRequestDTO);
        return ResponseEntity.ok(ApiResponse.onSuccess("리뷰가 성공적으로 작성되었습니다."));
    }

}
