package umc.spring.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.store.Store;
import umc.spring.dto.store.StoreRequestDTO;
import umc.spring.service.store.StoreQueryServiceImpl;


@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreQueryServiceImpl storeCommandService;

    @PostMapping
    @ResponseBody
    public ApiResponse<String> addStore(@RequestBody StoreRequestDTO request) {
        System.out.println("Received Request: " + request); // 디버깅 로그
        System.out.println("Region ID: " + request.getRegionId()); // regionId 출력

        Store store = storeCommandService.addStoreToRegion(request);
        return ApiResponse.onSuccess("가게가 등록되었습니다.");
    }

}

