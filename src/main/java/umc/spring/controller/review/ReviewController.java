package umc.spring.controller.review;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.member.Member;
import umc.spring.dto.mission.MyReveiwDTO;
import umc.spring.service.review.ReviewQueryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    final ReviewQueryServiceImpl reviewService;

    @GetMapping
    public Page<MyReveiwDTO> getReviews(
            @RequestParam(name = "memberId") Long memberId,
            @RequestParam(defaultValue = "0", name = "page") int page,  // 기본 0
            @RequestParam(defaultValue = "10", name = "size") int size  // 10개씩
    ) {
        return reviewService.findMyReviewList(memberId, page -1 , size);
    }

}
