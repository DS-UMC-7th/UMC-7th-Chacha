package umc.spring.dto.review;

import lombok.*;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

@Getter
public class ReviewRequestDTO {
     String content;         // 리뷰 내용
     Integer star;           // 별점 (1~5 범위)
     String comment;         // 추가 코멘트
     Long memberId;          // 작성자 ID
     List<String> imageUrls; // 첨부 이미지 URL 목록
    @ExistStores
     Long storeId;           // 리뷰 대상 가게 ID


}
